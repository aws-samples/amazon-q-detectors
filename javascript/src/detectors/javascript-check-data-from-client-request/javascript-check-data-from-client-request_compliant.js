// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-check-data-from-client-request@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/welcome', (req, res) => {
    // Compliant: No usage of user controlled data within `res.cookie(...)` .
    res.cookie("info_mod_date", new Date().toISOString());
    res.send("Welcome !");
});
// {/fact}
