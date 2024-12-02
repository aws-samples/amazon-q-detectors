// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dangerous-locals-as-template-context@v1.0 defects=0}
const express = require("express");
const app = express();

// Compliant: Local variable is used specific to the current request.
app.get('/', (request, response) => {
    var locals = {message: "Welcome"}
    return response.render("index", locals);
});
// {/fact}
