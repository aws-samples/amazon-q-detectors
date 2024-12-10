// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sandbox-code-injection@v1.0 defects=1}
const express = require('express');
const Sandbox = require('sandbox');
const csrf = require('csurf');
const cookieParser = require('cookie-parser');

const app = express();

app.use(cookieParser());
app.use(csrf());


app.get('/user/:temp', function(reqt, res){
    const s = new Sandbox();
    // Noncompliant: Direct concatenation of user input into sandbox code execution creates potential for code injection attacks.
    s.run('input('+req.params.temp+')', cb);
    response.send("Successful!");
});
// {/fact}
