package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.ConnectionCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.AccessDeniedException;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.InteroperabilityException;
import ch.cyberduck.core.features.AttributesFinder;
import ch.cyberduck.core.features.Encryption;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.http.AbstractHttpWriteFeature;
import ch.cyberduck.core.http.DelayedHttpEntityCallable;
import ch.cyberduck.core.http.HttpResponseOutputStream;
import ch.cyberduck.core.io.Checksum;
import ch.cyberduck.core.io.ChecksumCompute;
import ch.cyberduck.core.io.ChecksumComputeFactory;
import ch.cyberduck.core.io.HashAlgorithm;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.log4j.Logger;
import org.jets3t.service.ServiceException;
import org.jets3t.service.model.MultipartPart;
import org.jets3t.service.model.MultipartUpload;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.model.StorageObject;
import org.jets3t.service.utils.ServiceUtils;

import java.util.List;
import java.util.Map;

public class S3WriteFeature extends AbstractHttpWriteFeature<StorageObject> implements Write<StorageObject> {
    private static final Logger log = Logger.getLogger(S3WriteFeature.class);

    private final Preferences preferences
        = PreferencesFactory.get();

    private final PathContainerService containerService;
    private final S3Session session;
    private final S3MultipartService multipartService;
    private final Find finder;
    private final AttributesFinder attributes;

    public S3WriteFeature(final S3Session session) {
        this(session, new S3DefaultMultipartService(session));
    }

    public S3WriteFeature(final S3Session session, final S3MultipartService multipartService) {
        this(session, multipartService, new S3FindFeature(session), new S3AttributesFinderFeature(session));
    }

    public S3WriteFeature(final S3Session session, final S3MultipartService multipartService,
                          final Find finder, final AttributesFinder attributes) {
        super(finder, attributes);
        this.session = session;
        this.multipartService = multipartService;
        this.finder = finder;
        this.attributes = attributes;
        this.containerService = session.getFeature(PathContainerService.class);
    }

    @Override
    public HttpResponseOutputStream<StorageObject> write(final Path file, final TransferStatus status, final ConnectionCallback callback) throws BackgroundException {
        final S3Object object = this.getDetails(file, status);
        final DelayedHttpEntityCallable<StorageObject> command = new DelayedHttpEntityCallable<StorageObject>() {
            @Override
            public StorageObject call(final AbstractHttpEntity entity) throws BackgroundException {
                try {
                    final RequestEntityRestStorageService client = session.getClient();
                    client.putObjectWithRequestEntityImpl(
                        containerService.getContainer(file).getName(), object, entity, status.getParameters());
                    if(log.isDebugEnabled()) {
                        log.debug(String.format("Saved object %s with checksum %s", file, object.getETag()));
                    }
                    status.setVersion(object.getVersionId());
                }
                catch(ServiceException e) {
                    throw new S3ExceptionMappingService().map("Upload {0} failed", e, file);
                }
                return object;
            }

            @Override
            public long getContentLength() {
                return status.getLength();
            }
        };
        return this.write(file, status, command);
    }

    /**
     * Add default metadata
     */
    protected S3Object getDetails(final Path file, final TransferStatus status) {
        final S3Object object = new S3Object(containerService.getKey(file));
        final String mime = status.getMime();
        if(StringUtils.isNotBlank(mime)) {
            object.setContentType(mime);
        }
        final Checksum checksum = status.getChecksum();
        if(Checksum.NONE != checksum) {
            switch(checksum.algorithm) {
                case md5:
                    object.setMd5Hash(ServiceUtils.fromHex(checksum.hash));
                    break;
                case sha256:
                    object.addMetadata("x-amz-content-sha256", checksum.hash);
                    break;
            }
        }
        if(StringUtils.isNotBlank(status.getStorageClass())) {
            if(!S3Object.STORAGE_CLASS_STANDARD.equals(status.getStorageClass())) {
                // The default setting is STANDARD.
                object.setStorageClass(status.getStorageClass());
            }
        }
        final Encryption.Algorithm encryption = status.getEncryption();
        object.setServerSideEncryptionAlgorithm(encryption.algorithm);
        // If the x-amz-server-side-encryption is present and has the value of aws:kms, this header specifies the ID of the
        // AWS Key Management Service (KMS) master encryption key that was used for the object.
        object.setServerSideEncryptionKmsKeyId(encryption.key);
        for(Map.Entry<String, String> m : status.getMetadata().entrySet()) {
            object.addMetadata(m.getKey(), m.getValue());
        }
        return object;
    }

    /**
     * @return No Content-Range support
     */
    @Override
    public Append append(final Path file, final Long length) throws BackgroundException {
        if(length >= preferences.getLong("s3.upload.multipart.threshold")) {
            if(preferences.getBoolean("s3.upload.multipart")) {
                try {
                    final List<MultipartUpload> upload = multipartService.find(file);
                    if(!upload.isEmpty()) {
                        Long size = 0L;
                        for(MultipartPart completed : multipartService.list(upload.iterator().next())) {
                            size += completed.getSize();
                        }
                        return new Append(size);
                    }
                }
                catch(AccessDeniedException | InteroperabilityException e) {
                    log.warn(String.format("Ignore failure listing incomplete multipart uploads. %s", e));
                }
            }
        }
        if(finder.find(file)) {
            final PathAttributes attr = attributes.find(file);
            return new Append(false, true).withSize(attr.getSize()).withChecksum(attr.getChecksum());
        }
        return Write.notfound;
    }

    @Override
    public boolean temporary() {
        return false;
    }

    @Override
    public boolean random() {
        return false;
    }

    @Override
    public ChecksumCompute checksum(final Path file, final TransferStatus status) {
        return ChecksumComputeFactory.get(HashAlgorithm.sha256);
    }
}
