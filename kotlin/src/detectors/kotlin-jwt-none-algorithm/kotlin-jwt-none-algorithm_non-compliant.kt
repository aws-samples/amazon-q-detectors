// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-jwt-none-algorithm@v1.0 defects=1}
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

fun jwt_none_algorithm_noncompliant() {
    // Noncompliant: Using 'none' algorithm for JWT allows attackers to forge tokens without signature verification.
    val algorithm = Algorithm.none()
    val token = JWT.create()
        .withIssuer("example-issuer")
        .withClaim("username", "user123")
        .sign(algorithm)
}
// {/fact}
