// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-data-exfilteration@v1.0 defects=1}
const express = require('express');
const app = express();

function noncompliant() {
    app.get("nonCompliant", (req, res) => {
        try {
            const targetObject = {};
            // Noncompliant: Using `Object.assign` with `req.query` can introduce unsafe properties to `targetObject`.
            let data = Object.assign(targetObject, req.query);
        } catch (err) {
            console.log(err);
        }
        res.end("ok");
    });
}
// {/fact}
