// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0


// {fact rule=java-secure-algorithms-for-digital-signature@v1.0 defect=0}
import java.security.*;

public class SecureAlgorithmsForDigitalSignatureJavaCompliant {

    // Compliant: Secure algorithm "SHA256withRSA" used for digital signature.
    public void compliant(final PrivateKey privateKey) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update("test data".getBytes());
        signature.sign();
    }
}
// {/fact}