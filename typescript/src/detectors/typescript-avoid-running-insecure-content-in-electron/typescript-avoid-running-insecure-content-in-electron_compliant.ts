// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-running-insecure-content-in-electron@v1.0 defects=0}
import { app, BrowserView, BrowserWindow } from "electron";

function createCompliantWindow(): void {
    const mainWindow = new BrowserWindow({
        webPreferences: {
            // Compliant: `allowRunningInsecureContent` property is disabled.
            allowRunningInsecureContent: false
        }
    });

    mainWindow.loadURL('https://example.com');
}
// {/fact}
