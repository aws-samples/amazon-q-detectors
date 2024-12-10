// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-unsafe-http-methods@v1.0 defects=1}
const express = require("express")
const app = express()
const router = express.Router()

// Noncompliant: HTTP routes have been declared using the `all()` method in Express.
app.all("/welcome", function (request, response) {
    response.send("Welcome!!")
});
// {/fact}
