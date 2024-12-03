// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsanitized-input-in-origin-header@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

function nonCompliant() {
    app.post('/test', function (req, res) {
        const origin = req.query.origin;
        // Noncompliant: Unvalidated origin from user input enables potential CORS vulnerabilities.
        res.set(200, { 'Access-Control-Allow-Origin': origin });
    });
}
// {/fact}
