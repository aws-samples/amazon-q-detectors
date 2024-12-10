// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-url-instantiated@v1.0 defects=0}
var urllib = require('urllib');

var url1 = "https://cnodejs.org/" 

function compliant()
{
    // Compliant: HTTPS protocol is used in the URL, which is secure.
    urllib.request('https://cnodejs.org/', function (err, data, res) {
    if (err) {
        throw err; 
    }
    console.log(res.statusCode);
    console.log(res.headers);
    // data is Buffer instance
    console.log(data.toString());
    });
}
// {/fact}
