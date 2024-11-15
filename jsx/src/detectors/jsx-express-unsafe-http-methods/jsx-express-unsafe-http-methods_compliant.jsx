// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-unsafe-http-methods@v1.0 defects=0}
const express = require("express")
const router = express.Router()

function compliant() {
    // Compliant: Using safe HTTP method `GET` which is read-only and cannot modify server resources.
    router.get("/someurl", function (request, response) {
        response.send("...")
    })
}
// {/fact}
