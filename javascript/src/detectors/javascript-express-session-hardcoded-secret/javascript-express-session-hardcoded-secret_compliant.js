// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-session-hardcoded-secret@v1.0 defects=0}
const express = require("express");
const session = require("express-session");
const config = require("./config");

const app = express();

app.use(
    session({
        // Compliant: No hardcoded credential has been used.
        secret: config.secret, 
        resave: false,
        saveUninitialized: false
    })
);
// {/fact}
