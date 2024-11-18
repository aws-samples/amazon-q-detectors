// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-running-insecure-content-in-electron@v1.0 defects=1}
import { app, BrowserView, BrowserWindow } from "electron";

function createNonCompliantWindow(): void {
    const mainWindow = new BrowserWindow({
        webPreferences: {
            // Noncompliant: `allowRunningInsecureContent` property is enabled.
            allowRunningInsecureContent: true
        }
    });

    mainWindow.loadURL('https://example.com');
}
// {/fact}
