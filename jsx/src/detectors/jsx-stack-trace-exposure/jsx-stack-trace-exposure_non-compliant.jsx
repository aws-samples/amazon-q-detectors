// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-stack-trace-exposure@v1.0 defects=1}
var express = require('express')
var app = express()

function noncompliant() {
    app.get('www.example.com', (req, res) => {
        try {
            throw new Error('')
        }
        catch (e) {
            var stackTrace = e.stack || e.stacktrace
        }
        // Noncompliant: It is returning `stackTrace`.
        res.send(stackTrace)
    })
}
// {/fact}
