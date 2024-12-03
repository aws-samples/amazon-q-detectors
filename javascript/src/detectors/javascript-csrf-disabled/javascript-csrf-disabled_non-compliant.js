// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-csrf-disabled@v1.0 defects=1}
let csrf = require('csurf');
let express = require('express');
let app = express();

// Noncompliant: CSRF protection middleware is missing, making the endpoint vulnerable to cross-site request forgery attacks.
app.put('/somepage', parse_form, function (req, res) {
    res.send('done');
});
// {/fact}
