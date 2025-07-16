// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-weak-password-encoder@v1.0 defects=0}
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

class PasswordService {
    
    fun compliant(): PasswordEncoder {
        // Compliant: Using a strong password encoder (BCrypt) with sufficient strength
        return BCryptPasswordEncoder(12)
    }
    
    fun getAlternativeEncoder(): PasswordEncoder {
        // Compliant: Using another strong password encoder (Argon2)
        return Argon2PasswordEncoder(16, 32, 1, 65536, 10)
    }
}
// {/fact}
