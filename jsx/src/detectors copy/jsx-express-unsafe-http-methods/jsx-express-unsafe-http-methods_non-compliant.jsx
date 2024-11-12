// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-unsafe-http-methods@v1.0 defects=1}
const express = require("express")
const app = express()

function noncompliant() {
    // Noncompliant: `app.all()` allows unrestricted access to all HTTP methods without proper method-specific controls.
    app.all("/someurl", function (request, response) {   
        response.send("...")
    });
}
// {/fact}