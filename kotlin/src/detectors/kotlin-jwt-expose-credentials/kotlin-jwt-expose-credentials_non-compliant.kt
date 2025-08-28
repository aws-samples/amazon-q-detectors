// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-jwt-expose-credentials@v1.0 defects=1}
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

fun jwt_expose_credentials_noncompliant() {
    val secret = "123@abc"
    val algorithm = Algorithm.HMAC512(secret)
    
    // Noncompliant: Including password directly in JWT claims exposes sensitive credentials.
    val token = JWT.create()
        .withIssuer("example-issuer")
        .withClaim("username", "user123")
        .withClaim("password", "Secret123!")
        .sign(algorithm)
}
// {/fact}
