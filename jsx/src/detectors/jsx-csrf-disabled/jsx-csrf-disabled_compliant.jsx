// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-csrf-disabled@v1.0 defects=0}
let csrf = require('csurf');
let express = require('express');
let csrfProtection = csrf({cookie: { domain: "subdomains.example.com", path: "/trusted/path"}});
let app = express();

// Compliant: `csrf` middleware is used.
app.post('/somepage', parse_form, csrfProtection, function (req, res) {
    res.send('done');
});
// {/fact}