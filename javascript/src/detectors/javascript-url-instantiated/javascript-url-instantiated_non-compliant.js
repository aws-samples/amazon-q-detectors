// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-url-instantiated@v1.0 defects=1}
var urllib = require('urllib');

let url = "http://cnodejs.org/"

function nonCompliant()
{
    // Noncompliant: HTTP protocol is used in the URL, which is insecure.
    urllib.request('http://cnodejs.org/', function (err, data, res) {
    if (err) {
        throw err; 
    }
    console.log(res.statusCode);
    console.log(res.headers);
    console.log(data.toString());
    });
}
// {/fact}
