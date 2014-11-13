﻿// 
// Copyright (c) 2010-2014 Yves Langisch. All rights reserved.
// http://cyberduck.ch/
// 
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
// 
// Bug fixes, suggestions and comments should be sent to:
// yves@cyberduck.ch
// 

using System;
using System.IO;
using Ch.Cyberduck.Ui.Controller;
using ch.cyberduck.core;
using ch.cyberduck.core.editor;
using ch.cyberduck.core.local;
using org.apache.log4j;
using IOException = java.io.IOException;
using Path = ch.cyberduck.core.Path;
using DisabledTransferErrorCallback = ch.cyberduck.core.transfer.DisabledTransferErrorCallback;

namespace Ch.Cyberduck.Core.Editor
{
    public class SystemWatchEditor : BrowserBackgroundEditor
    {
        private static readonly Logger Log = Logger.getLogger(typeof (SystemWatchEditor).FullName);
        private FileSystemWatcher _watcher;

        public SystemWatchEditor(BrowserController controller, Session session, Application application, Path path)
            : base(controller, session, application, path)
        {
        }

        protected override void watch(ch.cyberduck.core.Local local)
        {
            _watcher = new FileSystemWatcher();
            _watcher.Path = local.getParent().getAbsolute();
            _watcher.Filter = local.getName();
            _watcher.NotifyFilter = NotifyFilters.LastAccess | NotifyFilters.LastWrite | NotifyFilters.FileName |
                                    NotifyFilters.DirectoryName;
            RegisterHandlers();
            // Begin watching.
            _watcher.EnableRaisingEvents = true;
        }

        private void HasRenamed(object sender, RenamedEventArgs e)
        {
            Log.debug(String.Format("HasRenamed: from {0} to {1}", e.OldFullPath, e.FullPath));
            save(new DisabledTransferErrorCallback());
        }

        private void HasChanged(object sender, FileSystemEventArgs e)
        {
            Log.debug("HasChanged:" + e.FullPath);
            save(new DisabledTransferErrorCallback());
        }

        public override void delete()
        {
            _watcher.EnableRaisingEvents = false;
            RemoveHandlers();
            base.delete();
        }

        private void RegisterHandlers()
        {
            _watcher.Changed += HasChanged;
            _watcher.Renamed += HasRenamed;
        }

        private void RemoveHandlers()
        {
            _watcher.Changed -= HasChanged;
            _watcher.Renamed -= HasRenamed;
        }
    }
}