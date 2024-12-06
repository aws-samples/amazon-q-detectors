// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-host-header-injection@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/', function (req, res) {
    // Noncompliant: Direct concatenation of `req.host` in URL construction makes application vulnerable to host header injection attacks.
    res.redirect('https://' + req.headers.host + '/password_reset');
})
// {/fact}
