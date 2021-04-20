package ch.cyberduck.core.onedrive;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.onedrive.features.GraphAttributesFinderFeature;
import ch.cyberduck.core.onedrive.features.GraphCopyFeature;
import ch.cyberduck.core.onedrive.features.GraphDeleteFeature;
import ch.cyberduck.core.onedrive.features.GraphDirectoryFeature;
import ch.cyberduck.core.onedrive.features.GraphFileIdProvider;
import ch.cyberduck.core.onedrive.features.GraphTouchFeature;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class GraphCopyFeatureTest extends AbstractOneDriveTest {

    @Test
    public void testCopy() throws Exception {
        final Path drive = new OneDriveHomeFinderService().find();
        final GraphFileIdProvider idProvider = new GraphFileIdProvider(session);
        Path directory = new GraphDirectoryFeature(session, idProvider).mkdir(
            new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory)), null, new TransferStatus());
        assertNotNull(new GraphAttributesFinderFeature(session).find(directory));
        final TransferStatus status = new TransferStatus();
        Path file = new GraphTouchFeature(session, idProvider).touch(new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file)), status.withMime("x-application/cyberduck"));
        assertNotNull(new GraphAttributesFinderFeature(session).find(file));
        Path rename = new Path(directory, file.getName(), EnumSet.of(Path.Type.file));
        final GraphCopyFeature copy = new GraphCopyFeature(session, idProvider);
        assertTrue(copy.isSupported(file, rename));
        final Path target = copy.copy(file, rename, new TransferStatus(), new DisabledConnectionCallback());
        assertNotEquals(status.getFileId(), target.attributes().getFileId());
        assertEquals(target.attributes().getFileId(), new GraphAttributesFinderFeature(session).find(rename).getFileId());
        new GraphDeleteFeature(session).delete(Arrays.asList(file, directory), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testCopyToExistingFile() throws Exception {
        final GraphFileIdProvider idProvider = new GraphFileIdProvider(session);
        final Path folder = new GraphDirectoryFeature(session, idProvider).mkdir(
            new Path(new OneDriveHomeFinderService().find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory)), null, new TransferStatus());
        final Path test = new GraphTouchFeature(session, idProvider).touch(new Path(folder, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file)), new TransferStatus());
        final String target = new AlphanumericRandomStringService().random();
        final Path copy = new GraphTouchFeature(session, idProvider).touch(new Path(folder, target, EnumSet.of(Path.Type.file)), new TransferStatus());
        new GraphCopyFeature(session, idProvider).copy(test, new Path(folder, target, EnumSet.of(Path.Type.file)), new TransferStatus().exists(true), new DisabledConnectionCallback());
        final Find find = new DefaultFindFeature(session);
        assertTrue(find.find(test));
        assertTrue(find.find(copy));
        new GraphDeleteFeature(session).delete(Arrays.asList(test, new Path(folder, target, EnumSet.of(Path.Type.file))), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }
}
