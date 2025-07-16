// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-jwt-expose-credentials@v1.0 defects=0}
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

fun jwt_expose_credentials_compliant() {
    val secretKey = System.getenv("JWT_SECRET_KEY")
    val algorithm = Algorithm.HMAC512(secretKey)
    
    // Compliant: Using only non-sensitive information in JWT claims.
    val token = JWT.create()
        .withIssuer("example-issuer")
        .withClaim("username", "user123")
        .withClaim("role", "user")
        .sign(algorithm)
}
// {/fact}
