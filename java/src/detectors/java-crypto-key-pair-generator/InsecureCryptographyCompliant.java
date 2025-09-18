// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-key-pair-generator@v1.0 defects=0}
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class InsecureCryptographyCompliant {

    // Compliant: Key size is sufficient for cryptographic algorithm.
    public void compliant() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096);
        keyPairGenerator.genKeyPair();
    }
}
// {/fact}
