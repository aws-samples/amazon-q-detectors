// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-avoid-running-insecure-content-in-electron@v1.0 defects=0}
const { app, BrowserView, BrowserWindow } = require("electron")

let mainWindow2 = new BrowserWindow({
    webPreferences: {
        // Compliant: Setting `allowRunningInsecureContent` to `false` prevents loading of insecure (HTTP) content in HTTPS pages.
        allowRunningInsecureContent: false
    }
})
// {/fact}
