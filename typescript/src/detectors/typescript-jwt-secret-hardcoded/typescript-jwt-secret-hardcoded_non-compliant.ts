// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-jwt-secret-hardcoded@v1.0 defects=1}
import jwt from 'jsonwebtoken';

function weakObfuscationOfRequestNoncompliant() {
    // Noncompliant: `secret` is hardcoded.
    const payload = "sss";
    var secret = "secret";
    jwt.sign(payload, secret);
}
// {/fact}
