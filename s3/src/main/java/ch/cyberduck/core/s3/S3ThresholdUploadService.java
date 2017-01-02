package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2013 David Kocher. All rights reserved.
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
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.ch
 */

import ch.cyberduck.core.ConnectionCallback;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathCache;
import ch.cyberduck.core.exception.AccessDeniedException;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.InteroperabilityException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.TransferAcceleration;
import ch.cyberduck.core.features.Upload;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.io.BandwidthThrottle;
import ch.cyberduck.core.io.StreamListener;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.ssl.X509KeyManager;
import ch.cyberduck.core.ssl.X509TrustManager;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;
import org.jets3t.service.model.StorageObject;

public class S3ThresholdUploadService implements Upload<StorageObject> {
    private static final Logger log = Logger.getLogger(S3ThresholdUploadService.class);

    private final Preferences preferences
            = PreferencesFactory.get();

    private final S3Session session;

    private Long multipartThreshold
            = preferences.getLong("s3.upload.multipart.threshold");

    private final TransferAcceleration<S3Session> accelerateTransferOption;

    private final X509TrustManager trust;
    private final X509KeyManager key;

    private final S3SingleUploadService singleUploadService;
    private final S3MultipartUploadService multipartUploadService;

    public S3ThresholdUploadService(final S3Session session, final X509TrustManager trust, final X509KeyManager key, final S3SingleUploadService singleUploadService, final S3MultipartUploadService multipartUploadService) {
        this(session, trust, key, PreferencesFactory.get().getLong("s3.upload.multipart.threshold"), singleUploadService, multipartUploadService);
    }

    public S3ThresholdUploadService(final S3Session session, final X509TrustManager trust, final X509KeyManager key,
                                    final Long multipartThreshold, final S3SingleUploadService singleUploadService, final S3MultipartUploadService multipartUploadService) {
        this(session, trust, key, multipartThreshold, new S3TransferAccelerationService(session), singleUploadService, multipartUploadService);
    }

    public S3ThresholdUploadService(final S3Session session, final X509TrustManager trust, final X509KeyManager key,
                                    final TransferAcceleration<S3Session> accelerateTransferOption, final S3SingleUploadService singleUploadService, final S3MultipartUploadService multipartUploadService) {
        this(session, trust, key, PreferencesFactory.get().getLong("s3.upload.multipart.threshold"), accelerateTransferOption, singleUploadService, multipartUploadService);
    }

    public S3ThresholdUploadService(final S3Session session, final X509TrustManager trust, final X509KeyManager key,
                                    final Long multipartThreshold,
                                    final TransferAcceleration<S3Session> accelerateTransferOption, final S3SingleUploadService singleUploadService, final S3MultipartUploadService multipartUploadService) {
        this.session = session;
        this.trust = trust;
        this.key = key;
        this.multipartThreshold = multipartThreshold;
        this.accelerateTransferOption = accelerateTransferOption;
        this.singleUploadService = singleUploadService;
        this.multipartUploadService = multipartUploadService;
    }

    @Override
    public Write.Append append(final Path file, final Long length, final PathCache cache) throws BackgroundException {
        return session.getFeature(Write.class, new S3WriteFeature(session)).append(file, length, cache);
    }

    @Override
    public StorageObject upload(final Path file, Local local, final BandwidthThrottle throttle, final StreamListener listener,
                                final TransferStatus status, final ConnectionCallback prompt) throws BackgroundException {
        final Host bookmark = session.getHost();
        try {
            if(accelerateTransferOption.getStatus(file) ||
                    (preferences.getBoolean("s3.accelerate.prompt") && accelerateTransferOption.prompt(bookmark, file, status, prompt))) {
                final S3Session tunneled = accelerateTransferOption.open(bookmark, file, trust, key);
                if(log.isInfoEnabled()) {
                    log.info(String.format("Tunnel upload for file %s through accelerated endpoint %s", file, tunneled));
                }
                if(status.getLength() > multipartThreshold) {
                    if(!preferences.getBoolean("s3.upload.multipart")) {
                        log.warn("Multipart upload is disabled with property s3.upload.multipart");
                        // Disabled by user
                        if(status.getLength() < preferences.getLong("s3.upload.multipart.required.threshold")) {
                            // Use single upload service with accelerate proxy
                            final S3SingleUploadService single = new S3SingleUploadService(tunneled, tunneled.getFeature(Write.class, new S3WriteFeature(tunneled, new S3DisabledMultipartService())));
                            return single.upload(file, local, throttle, listener, status, prompt);
                        }
                    }
                    // Use multipart upload service with accelerate proxy
                    final Upload<StorageObject> service = new S3MultipartUploadService(tunneled);
                    return service.upload(file, local, throttle, listener, status, prompt);
                }
                // Use single upload service with accelerate proxy
                final S3SingleUploadService service = new S3SingleUploadService(tunneled, tunneled.getFeature(Write.class, new S3WriteFeature(tunneled, new S3DisabledMultipartService())));
                return service.upload(file, local, throttle, listener, status, prompt);
            }
            log.warn(String.format("Transfer acceleration disabled for %s", file));
        }
        catch(AccessDeniedException e) {
            log.warn(String.format("Ignore failure reading S3 accelerate configuration. %s", e.getMessage()));
        }
        if(status.getLength() > multipartThreshold) {
            if(!preferences.getBoolean("s3.upload.multipart")) {
                log.warn("Multipart upload is disabled with property s3.upload.multipart");
                // Disabled by user
                if(status.getLength() < preferences.getLong("s3.upload.multipart.required.threshold")) {
                    // Use single upload service
                    return singleUploadService.upload(file, local, throttle, listener, status, prompt);
                }
            }
            try {
                return multipartUploadService.upload(file, local, throttle, listener, status, prompt);
            }
            catch(NotfoundException | InteroperabilityException e) {
                log.warn(String.format("Failure using multipart upload %s. Fallback to single upload.", e.getMessage()));
            }
        }
        // Use single upload service
        return singleUploadService.upload(file, local, throttle, listener, status, prompt);
    }

    public S3ThresholdUploadService withMultipartThreshold(final Long threshold) {
        this.multipartThreshold = threshold;
        return this;
    }
}