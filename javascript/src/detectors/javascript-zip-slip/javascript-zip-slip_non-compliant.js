// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-zip-slip@v1.0 defects=1}
const AdmZip = require('adm-zip');
const extract = require('extract-zip')
const yauzl = require('yauzl');
const pathmodule = require('path');
const unzipper = require('./unzip');
const fs = require('fs');
const { finished } = require('stream');
const unzip = require('unzip');
const tar = require('tar-stream');


function nonCompliant() {
    const adm = new AdmZip("./zip-slip.zip");
    const zipEntries = adm.getEntries();
    zipEntries.forEach(function (zipEntry) {
        // Compliant: Creating file paths from untrusted input.
        fs.createWriteStream(zipEntry.entryName);
    });
}
// {/fact}
