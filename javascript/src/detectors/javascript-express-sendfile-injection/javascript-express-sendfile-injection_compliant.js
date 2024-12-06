// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-sendfile-injection@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require("express");
const path = require("path");

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get("/", (req, res) => {
    const file = "foo";
    // Compliant: Using hardcoded file name and `path.resolve()` ensures safe file path resolution without user input manipulation risks.
    res.sendFile(path.resolve("ftp/", file));
});
// {/fact}
