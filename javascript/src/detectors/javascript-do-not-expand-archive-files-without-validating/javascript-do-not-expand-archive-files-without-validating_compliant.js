// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-expand-archive-files-without-validating@v1.0 defects=0}
const AdmZip = require('adm-zip');
const express = require('express');
const multer = require('multer');
const fileUpload = require('express-fileupload');

const app = express();

app.use(fileUpload({
    createParentPath: true
}));

var upload = multer({dest:'uploads/'});

app.post('/upload-file',  (req, res) => {
    let fileName = req.files.fileName;
    let fileCount = 0;
    let totalSize = 0;

    let zip = new AdmZip(fileName);
    let zipEntries = zip.getEntries();

    // Compliant: Verified archive files are expanded by controlling the size of the expanded data.
    zipEntries.forEach(function(zipEntry) {
        fileCount++;
        if (fileCount > MAX_FILES) {
            throw 'Reached max. number of files';
        }

        let entrySize = zipEntry.getData().length;
        totalSize += entrySize;
        if (totalSize > MAX_SIZE) {
            throw 'Reached max. size';
        }

        let compressionRatio = entrySize / zipEntry.header.compressedSize;
        if (compressionRatio > THRESHOLD_RATIO) {
            throw 'Reached max. compression ratio';
        }

        if (!zipEntry.isDirectory) {
            zip.extractEntryTo(zipEntry.entryName, ".");
        }
    });
})
// {/fact}
