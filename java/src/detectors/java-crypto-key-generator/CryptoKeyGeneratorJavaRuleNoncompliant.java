// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-key-generator@v1.0 defects=1}
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;


class CryptoKeyGeneratorJavaRuleNoncompliant {
    // Noncompliant: Uses a weak key size (128 bits) for AES, which is considered insufficient for long-term security.
    public void nonCompliant() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
    }
}
// {/fact}
