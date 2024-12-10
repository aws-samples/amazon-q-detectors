// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsafe-serialize@v1.0 defects=1}
const express= require('express')
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const serialize = require('serialize-javascript');

const app = express();

app.use(cookieParser());
app.use(csrf());

app.get("/query", (req, res) => {
    var userInput = req.params.userinput;
    // Noncompliant: Using `{unsafe: true}` option in `serialize()` with user input allows potentially dangerous code execution during deserialization.
    const result = serialize({foo: userInput}, {unsafe: true, space: 2})
    return result
})
// {/fact}
