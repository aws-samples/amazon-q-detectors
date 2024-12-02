// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dangerous-locals-as-template-context@v1.0 defects=1}
const express = require("express");
const app = express();

// Noncompliant: Passing all local variables from `app.locals` directly into the template expose unnecessary
// or sensitive data to the template
app.get('/', (request, response) => {
    return response.render("index", app.locals);
});
// {/fact}
