// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-stack-trace-exposure@v1.0 defects=0}
var express = require('express')
var app = express()
function stackTraceExposureCompliant() {
    app.get('www.example.com', (req, res) => {
        try {
            throw new Error('')
        }
        catch (e) {
            var stackTrace = e.stack || e.stacktrace
        }
        // Compliant: It is not returning `stackTrace`.
        res.status(500).send('An unexpected error occurred. Please try again later.');
    })
}
// {/fact}
