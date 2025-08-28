// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-hardcoded-secrets-basic-ide@v1.0 defects=1}
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

fun noncompliant() {
    // Noncompliant: Hardcoded JWT secret directly in the source code.
    val jwtSecret = "jwt_super_secret_key_for_signing_tokens_1234567890"
    
    val jwt = Jwts.builder()
        .setSubject("user123")
        .claim("role", "admin")
        .signWith(SignatureAlgorithm.HS256, jwtSecret.toByteArray())
        .compact()
    
    println("Generated JWT: $jwt")
}
// {/fact}
