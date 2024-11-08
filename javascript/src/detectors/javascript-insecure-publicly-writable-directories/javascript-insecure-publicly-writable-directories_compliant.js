// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-insecure-publicly-writable-directories@v1.0 defects=0}
var fs = require('fs')
var tmp = require('tmp')
function insecureTempFileCompliant() {
    // Compliant: Using `tmp` library to securely create or read temporary files in a controlled subdirectory.
    tmp.file(function _tempFileCreated(err, tmp_file, fd) {
        if (err) throw err;
        fs.readFile(tmp_file, 'utf8', function (err, data) {
            if (err) throw err;
            // ...
        })
    })
}
// {/fact}