// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sandbox-code-injection@v1.0 defects=0}
const Sandbox = require('sandbox');
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/user/:temp',(req,res) =>
{
    const s = new Sandbox();
    // Compliant: Using sandbox environment with CSRF protection to safely execute code and prevent unauthorized code injection attacks.
    s.run('input("anyinput")', cb);
    res.send("Successful!");
});
// {/fact}
