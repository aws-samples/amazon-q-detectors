// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-jwt-none-algorithm@v1.0 defects=0}
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.SignatureAlgorithm

fun jwt_none_algorithm_compliant() {
    // Compliant: Using a secure algorithm (HMAC256) with a proper key for JWT signing.
    val secretKey = System.getenv("JWT_SECRET_KEY")
    val algorithm = Algorithm.HMAC256(secretKey)
    val token = JWT.create()
        .withIssuer("example-issuer")
        .withClaim("username", "user123")
        .sign(algorithm)
}
// {/fact}
