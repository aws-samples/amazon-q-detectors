// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-csrf-disabled@v1.0 defects=1}
let csrf = require('csurf');
let express = require('express');
let app = express();

function noncompliant() {
    // Noncompliant: `POST` is unsafe http method.
    app.use(csrf({ cookie: true, ignoreMethods: ["POST", "GET"] }));
}
// {/fact}