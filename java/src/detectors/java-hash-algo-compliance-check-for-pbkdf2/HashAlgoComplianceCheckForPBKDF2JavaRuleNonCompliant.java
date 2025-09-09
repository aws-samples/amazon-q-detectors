// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=1}
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class HashAlgoComplianceCheckForPBKDF2JavaRuleNonCompliant {

    // Noncompliant: Weak Algorithm `SHA1` is used .
    void nonCompliant() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = System.getenv("password");
        final SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        final PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), new byte[32], 65000, 128);
        final SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
    }
}
// {/fact}
