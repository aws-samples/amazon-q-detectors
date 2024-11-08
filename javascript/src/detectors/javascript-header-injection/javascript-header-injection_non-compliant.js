// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-header-injection@v1.0 defects=1}
var express = require('express')
var app = express()
function headerInjectionNoncompliant() {
    app.get("www.example.com", function (req, res) {
        // Noncompliant: Directly using untrusted user input in response headers.
        res.setHeader("Content-Type", req.query.type)
    })
}
// {/fact}
