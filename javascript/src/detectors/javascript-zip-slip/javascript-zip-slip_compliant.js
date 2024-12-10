// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-zip-slip@v1.0 defects=0}
const AdmZip = require('adm-zip');
const extract = require('extract-zip')
const yauzl = require('yauzl');
const pathmodule = require('path');
const unzipper = require('./unzip');
const fs = require('fs');
const { finished } = require('stream');
const unzip = require('unzip');
const tar = require('tar-stream');


import fs from "fs";
import pathmodule from "path";
import {finished} from "stream";

function compliant() {
    fs.createReadStream('path/to/archive.zip')
        .pipe(unzipper.Parse())
        .on('entry', function (entry) {
            const fileName = entry.path;
            const type = entry.type; 
            const size = entry.vars.uncompressedSize; 
            // Compliant: Creating file paths from trusted input.
            entry.pipe(fs.createWriteStream('output/path'));
        });
}
// {/fact}
