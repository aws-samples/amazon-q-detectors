// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-non-httponly-cookie@v1.0 defects=0}
var cookieSession = require('cookie-session')
var express = require('express')
var app = express()
function insecureCookieCompliant() {
    // Compliant: `httpOnly` is enabled by default, securing the cookie from javascript access.
    let session = app.use(cookieSession({
        name: 'session',
        secret: "secret",
    }))
}
// {/fact}
