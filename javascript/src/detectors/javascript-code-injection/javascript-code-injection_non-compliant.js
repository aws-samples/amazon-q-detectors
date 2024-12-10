// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-code-injection@v1.0 defects=1}
const express = require("express");
const app = express();

function nonCompliant() {
    app.get("/add/:num1/:num2", function (req, res) {
        // Noncompliant: Untrusted user input is being passed into dynamically executable code.
        eval(req.params.num1 + "+" + req.params.num2);
        res.send("Evaluated the result");
    });
}
// {/fact}
