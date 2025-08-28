// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-weak-password-encoder@v1.0 defects=1}
import org.springframework.security.crypto.password.StandardPasswordEncoder

class PasswordService {
    
    fun noncompliant() {
        // Noncompliant: Using `StandardPasswordEncoder` which is deprecated for security reasons
        val encoder = StandardPasswordEncoder()
        val password = "userPassword"
        val encodedPassword = encoder.encode(password)
    }
}
// {/fact}
