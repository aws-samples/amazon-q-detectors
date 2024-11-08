// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-insecure-publicly-writable-directories@v1.0 defects=1}
var fs = require('fs')
function insecureTempFileNoncompliant() {
    // Noncompliant: Using publicly writable directory `/tmp` can expose files to unauthorized access.
    var tmp_file = "/tmp/f"
    fs.readFile(tmp_file, 'utf8', function (err, data) {
       // ...
    })
}
// {/fact}
