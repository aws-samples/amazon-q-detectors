// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-header-injection@v1.0 defects=0}
var express = require('express')
var app = express()

function compliant() {
    app.get("www.example.com", function (req, res) {
        // Compliant: User input in headers is validated against allowed types before setting.
        var contentType = req.query.contentType || "text/html"
        
        var validContentTypes = ['text/html', 'application/json', 'text/plain']
        if (validContentTypes.includes(contentType)) {
            res.setHeader("Content-Type", contentType)
        } else {
            res.setHeader("Content-Type", "text/html")
        }
    })
}
// {/fact}