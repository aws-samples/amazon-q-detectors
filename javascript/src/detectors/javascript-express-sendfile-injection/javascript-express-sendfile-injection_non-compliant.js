// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-sendfile-injection@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require("express");
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get("/", (req, res) => {
    // Noncompliant: Using unvalidated user input directly in `sendFile()` can lead to directory traversal attacks.
    res.sendFile(req.params.foo, { root: "/" });
});
// {/fact}
