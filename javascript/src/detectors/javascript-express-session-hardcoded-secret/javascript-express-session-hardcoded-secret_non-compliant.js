// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-session-hardcoded-secret@v1.0 defects=1}
const express = require("express");
const session = require("express-session");
const app = express();

function nonCompliant() {
    app.use(
        session({
            // Noncompliant: Hardcoded credential has been used.
            secret: "foo",
            resave: false,
            saveUninitialized: false
        })
    );
}
// {/fact}
