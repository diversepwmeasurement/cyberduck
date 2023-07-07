package ch.cyberduck.ui.cocoa.callback;

/*
 * Copyright (c) 2002-2023 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.binding.WindowController;
import ch.cyberduck.binding.application.SheetCallback;
import ch.cyberduck.core.exception.ConnectionCanceledException;
import ch.cyberduck.core.features.PromptUrlProvider;
import ch.cyberduck.ui.cocoa.controller.ShareeController;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class PromptShareeCallback implements PromptUrlProvider.ShareeCallback {
    private final WindowController parent;

    public PromptShareeCallback(final WindowController parent) {
        this.parent = parent;
    }

    @Override
    public PromptUrlProvider.Sharee prompt(final Set<PromptUrlProvider.Sharee> sharees) throws ConnectionCanceledException {
        final AtomicReference<PromptUrlProvider.Sharee> selected = new AtomicReference<>();
        final ShareeController controller = new ShareeController(sharees, selected::set);
        final int option = controller.beginSheet(parent);
        if(option == SheetCallback.CANCEL_OPTION) {
            throw new ConnectionCanceledException();
        }
        return selected.get();
    }
}
