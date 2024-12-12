// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-unserialized-parsed-data@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require("express");

const app = express();

app.use(cookieParser());
app.use(express.text({ type: "application/json" }));

const csrfProtection = csrf();
app.use(csrfProtection);

app.route("/data")
    .get((req, res) => {
        res.send("Send a POST request with raw JSON to this endpoint.");
    })
    .post((req, res) => {
        let jsondata = JSON.stringify(req.body.obj);

        try {
            // Compliant: Object is serialized before being parsed.
            const jsonParsed = JSON.parse(jsondata);

            res.send("JSON parsed successfully!");
        } catch (error) {
            res.status(400).send("Invalid JSON format!");
        }
    });
// {/fact}
