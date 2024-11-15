// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-insecure-publicly-writable-directories@v1.0 defects=1}
var fs = require('fs')

function noncompliant() {
    // Noncompliant: Using publicly writable directory `/tmp` can expose files to unauthorized access.
    var tmp_file = "/tmp/f"
    fs.readFile(tmp_file, 'utf8', function (err, data) {
       // ...
    })
}
// {/fact}
