// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-regex-dos-attack@v1.0 defects=0}
var express = require('express')
var escapeStringRegexp = require('escape-string-regexp')
var app = express()
function nonLiteralRegularExpressionCompliant() {
    app.get("www.example.com", (req, res) => {
        var re = new RegExp('ab+c')
        // Compliant: Validated user input before applying regex test to prevent `ReDoS` vulnerabilities.
        var test = re.test(escapeStringRegexp(req.body.id))
    })
}
// {/fact}
