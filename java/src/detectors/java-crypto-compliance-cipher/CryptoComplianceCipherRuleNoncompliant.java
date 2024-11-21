// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-compliance-cipher@v1.0 defects=1}
import javax.crypto.Cipher;

class CryptoComplianceCipherRuleNoncompliant {

    // Noncompliant: Uses an insecure cipher algorithm DES which is vulnerable to various attacks.
    public void nonCompliant() throws Exception {
        final Cipher c = Cipher.getInstance("des");
        c.doFinal();
    }
}
// {/fact}
