// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-key-generator@v1.0 defects=0}
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;

class CryptoKeyGeneratorJavaRuleCompliant {

    // Compliant: Uses 256 bit key for AES, which is considered sufficient for long-term security.
    public void compliant() throws NoSuchAlgorithmException {
        KeyGenerator c = KeyGenerator.getInstance("AES");
        c.init(256);
        c.generateKey();
    }
}
// {/fact}