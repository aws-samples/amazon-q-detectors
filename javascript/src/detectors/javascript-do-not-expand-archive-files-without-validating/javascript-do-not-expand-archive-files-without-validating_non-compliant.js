// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-expand-archive-files-without-validating@v1.0 defects=1}
const AdmZip = require('adm-zip');
const express = require('express');
const multer = require('multer');
const fileUpload = require('express-fileupload');

const app = express();

app.use(fileUpload({
    createParentPath: true
}));

var upload = multer({dest:'uploads/'});

function nonCompliant(){
    app.post('/upload-avatar',  (req, res) => {
        let fileName = req.files.fileName;
        let zip = new AdmZip(fileName);

        // Noncompliant: Unverified archive files are expanded without controlling the size of the expanded data.
        zip.extractAllTo("./extractedFolder");
    })
}


// {/fact}
