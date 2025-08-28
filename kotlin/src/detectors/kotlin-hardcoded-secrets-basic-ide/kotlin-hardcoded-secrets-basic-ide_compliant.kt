// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-hardcoded-secrets-basic-ide@v1.0 defects=0}
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

fun compliant() {
    // Compliant: JWT secret retrieved from environment variable instead of hardcoding.
    val jwtSecret = System.getenv("JWT_SECRET_KEY")
        ?: throw IllegalStateException("JWT_SECRET_KEY environment variable not set")
    
    val jwt = Jwts.builder()
        .setSubject("user123")
        .claim("role", "admin")
        .signWith(SignatureAlgorithm.HS256, jwtSecret.toByteArray())
        .compact()
    
    println("Generated JWT: $jwt")
}
// {/fact}
