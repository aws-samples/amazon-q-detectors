// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-path-injection-in-io-calls@v1.0 defects=1}
const express = require("express")
const fs = require('fs');
const pathmodule = require("path");

const app = express();

app.get("/read", function(req, res) {

    const path = req.query.filepath;

    // Noncompliant: `path` hasn't been sanitized. It could contain characters like `~/`  or `../`.
    let data = fs.readFileSync(path);

    res.send(data);
});
// {/fact}
