// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsanitized-input-in-origin-header@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);


app.get('/test', function (req, res) {
    // Compliant: Hardcoded trusted origin prevents CORS security risks.
    res.set('access-control-allow-origin', 'trustedwebsite.com')
});
// {/fact}
