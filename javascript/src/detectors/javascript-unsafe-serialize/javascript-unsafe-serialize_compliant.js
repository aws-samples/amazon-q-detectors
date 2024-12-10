// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unsafe-serialize@v1.0 defects=0}
const express= require('express')
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const serialize = require('serialize-javascript');

const app = express();

app.use(cookieParser());
app.use(csrf());

app.get("/query", (req, res) => {
    data = req.body
    // Compliant: Using serialize-javascript library for safe serialization of data prevents code injection and prototype pollution attacks.
    const result = serialize({foo: data}, {space: 2})
    return result
})
// {/fact}
