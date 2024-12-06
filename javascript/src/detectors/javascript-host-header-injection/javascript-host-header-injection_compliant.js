// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-host-header-injection@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/', function (req, res) {
    // Compliant: Host value has been safely sanitized.
    res.redirect('https://' + req.headers.host.replace(/:.*/, '') + '/password-reset');
})
// {/fact}
