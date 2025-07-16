// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-incorrect-password-hashing@v1.0 defects=1}
import java.security.MessageDigest
import java.nio.charset.StandardCharsets

class PasswordService {
    
    fun hashPassword(password: String): ByteArray {
        // Noncompliant: Using MessageDigest for password hashing is insecure
        val md = MessageDigest.getInstance("SHA-256")
        return md.digest(password.toByteArray(StandardCharsets.UTF_8))
    }
}
// {/fact}
