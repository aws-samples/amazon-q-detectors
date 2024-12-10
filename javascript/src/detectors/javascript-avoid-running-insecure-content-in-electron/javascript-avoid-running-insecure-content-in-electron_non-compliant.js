// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-avoid-running-insecure-content-in-electron@v1.0 defects=1}
const { app, BrowserView, BrowserWindow } = require("electron")

let mainWindow1 = new BrowserWindow({
    webPreferences: {
        // Noncompliant: Setting `allowRunningInsecureContent` to `true` allows loading of insecure HTTP content in HTTPS pages, creating security vulnerabilities.
        allowRunningInsecureContent: true
    }
})
// {/fact}
