// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-jwt-parsing@v1.0 defects=1}
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Claims

// Noncompliant: Using hardcoded key for JWT parsing and not validating signature properly.
fun insecure_jwt_parsing_noncompliant(token: String): Claims {
    val hardcodedKey = "my-hardcoded-secret-key-which-is-not-secure"
    
    return Jwts.parser()
        .setSigningKey(hardcodedKey)
        .parse(token)
        .body as Claims
}
// {/fact}
