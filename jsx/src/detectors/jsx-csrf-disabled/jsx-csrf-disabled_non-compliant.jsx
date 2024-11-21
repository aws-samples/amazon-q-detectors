// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-csrf-disabled@v1.0 defects=1}
let csrf = require('csurf')
let express = require('express')
let app = express()

function noncompliant() {
    // Noncompliant: CSRF middleware is misconfigured, allowing unsafe methods like POST to bypass protection, which can lead to vulnerabilities.
    app.use(csrf({ cookie: true, ignoreMethods: ["POST", "GET"] }))
}
// {/fact}