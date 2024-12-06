// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-csrf-disabled@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

// Compliant: CSRF protection is properly enabled.
app.get('/welcome', (req, res) => {
    res.send(`Welcome Guest`);
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
// {/fact}
