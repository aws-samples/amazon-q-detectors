// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-session-hardcoded-secret@v1.0 defects=1}
import express from "express";
import session from "express-session";

const app = express();

function nonCompliant(): void {
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
