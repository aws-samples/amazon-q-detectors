// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-incorrect-password-hashing@v1.0 defects=0}
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import java.security.SecureRandom
import java.util.Base64

class PasswordService {
    
    fun hashPassword(password: String): String {
        // Compliant: Using PBKDF2 with a random salt and multiple iterations
        val random = SecureRandom()
        val salt = ByteArray(16)
        random.nextBytes(salt)

        val spec = PBEKeySpec(password.toCharArray(), salt, 65536, 128)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val hash = factory.generateSecret(spec).encoded
        
        return Base64.getEncoder().encodeToString(hash)
    }
}
// {/fact}
