// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-jwt-secret-hardcoded@v1.0 defects=0}
var jwt = require('jsonwebtoken')

function compliant() {
    // Compliant: `secret` is securely loaded from environment variables, avoiding hardcoding.
    var secret = process.env.JWT_TOKEN_SECRET
    jwt.sign(payload, secret)
}
// {/fact}
