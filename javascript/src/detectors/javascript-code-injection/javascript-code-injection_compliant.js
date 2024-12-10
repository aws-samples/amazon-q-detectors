// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-code-injection@v1.0 defects=0}
const express = require("express");
const app = express();

const axios = require('axios');

function compliant() {
    app.get("/add", function (req, res) {
        // Compliant: Trusted user input is being passed into dynamically executable code.
        let calculated = eval("2 + 3")
        res.send("Addition has been calculated");
    });
}

// {/fact}
