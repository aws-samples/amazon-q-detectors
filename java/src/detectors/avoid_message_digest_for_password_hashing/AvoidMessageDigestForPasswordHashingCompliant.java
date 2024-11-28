// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-message-digest-for-password-hashing@v1.0 defects=0}
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

class AvoidMessageDigestForPasswordHashingCompliant {
    String PASSWORD = "Pass@123";
    String SALT = "unique_salt";

    // Compliant: Use of `PBKDF2` for password hashing.
    public String compliant() throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 65536;
        int keyLength = 256;
        char[] passwordChars = PASSWORD.toCharArray();
        byte[] saltBytes = SALT.getBytes();

        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedBytes = keyFactory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hashedBytes);
    }
}
