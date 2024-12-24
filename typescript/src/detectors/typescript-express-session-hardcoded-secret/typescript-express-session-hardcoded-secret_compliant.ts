// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-session-hardcoded-secret@v1.0 defects=0}
import express from "express";
import session from "express-session";
import config from "./config";

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
