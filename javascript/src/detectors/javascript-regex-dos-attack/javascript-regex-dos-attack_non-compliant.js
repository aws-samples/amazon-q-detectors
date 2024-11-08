// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-regex-dos-attack@v1.0 defects=1}
var express = require('express')
var app = express()
function nonLiteralRegularExpressionNoncompliant() {
    app.get("www.example.com", (req, res) => {
        var re = new RegExp('ab+c')
        // Noncompliant: User input is used in regex test without sanitization.
        var test = re.test(req.body.id)
    })
}
// {/fact}
