// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-log-injection@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/ping_server', (req, res) => {
    // Compliant: Passing user controlled input directly to `console.log` method.
    console.log(`Received data at ${req.query.time_string}`)
    res.send("Received ping");
});
// {/fact}
