// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-compliance-cipher@v1.0 defects=0}
import javax.crypto.Cipher;

public class CryptoComplianceCipherRuleCompliant {
    // Compliant: Uses a secure cipher algorithm (RSA with OAEP padding) for encryption.
    public void compliant() throws Exception {
        final Cipher c = Cipher.getInstance("RSA/ECB/OAEPPadding");
        c.doFinal();
    }
}
// {/fact}