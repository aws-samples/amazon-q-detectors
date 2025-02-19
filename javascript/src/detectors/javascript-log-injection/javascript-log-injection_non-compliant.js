// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-log-injection@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/ping_server', (req, res) => {
    // Noncompliant: Logged data doesn't include any user controlled input.
    console.log(`Received data at: ${new Date().toISOString()}`)
    res.send("Received ping");
});
// {/fact}
