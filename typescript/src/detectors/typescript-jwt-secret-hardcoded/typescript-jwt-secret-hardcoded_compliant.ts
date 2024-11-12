// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-jwt-secret-hardcoded@v1.0 defects=0}
import jwt from 'jsonwebtoken';

var payload: number;

function weakObfuscationOfRequestCompliant() {
    // Compliant: `secret` is properly loaded from environment variables.
    var secret = process.env.JWT_TOKEN_SECRET;
    jwt.sign(payload, secret);
}
// {/fact}
