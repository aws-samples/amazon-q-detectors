// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-non-httponly-cookie@v1.0 defects=1}
var cookieSession = require('cookie-session')
var express = require('express')
var app = express()

function noncompliant() {
    let session = app.use(cookieSession({
        name: 'session',
        secret: "secret",
        // Noncompliant: Disabling `httpOnly` exposes the cookie to potential XSS attacks.
        httpOnly: false,
    }))
}
// {/fact}
