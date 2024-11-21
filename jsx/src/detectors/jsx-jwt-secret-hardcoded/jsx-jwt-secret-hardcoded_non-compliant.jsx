// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-jwt-secret-hardcoded@v1.0 defects=1}
var jwt = require('jsonwebtoken')

function noncompliant() {
    // Noncompliant: Hardcoding the `secret` key in the code exposes it to potential leaks.
    var secret = "secret"
    jwt.sign(payload, secret)
}
// {/fact}
