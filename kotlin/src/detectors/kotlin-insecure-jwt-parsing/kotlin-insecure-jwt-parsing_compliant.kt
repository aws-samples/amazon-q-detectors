// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-jwt-parsing@v1.0 defects=0}
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Claims
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException

// Compliant: Using environment variable for key, proper signature verification, and exception handling.
fun insecure_jwt_parsing_compliant(token: String): Claims? {
    val secretKey = System.getenv("JWT_SECRET_KEY")
    
    return try {
        val key = Keys.hmacShaKeyFor(secretKey.toByteArray())
        Jwts.parserBuilder()
            .setSigningKey(key)
            .requireIssuer("trusted-issuer")
            .build()
            .parseClaimsJws(token)
            .body
    } catch (e: SignatureException) {
        println("Invalid JWT signature")
        null
    } catch (e: MalformedJwtException) {
        println("Invalid JWT token")
        null
    } catch (e: ExpiredJwtException) {
        println("Expired JWT token")
        null
    } catch (e: UnsupportedJwtException) {
        println("Unsupported JWT token")
        null
    } catch (e: IllegalArgumentException) {
        println("JWT claims string is empty")
        null
    }
}
// {/fact}
