// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-secure-algorithms-for-digital-signature@v1.0 defects=1}
import java.security.*;

public class SecureAlgorithmsForDigitalSignatureJavaNonCompliant {

    // Noncompliant: Weak algorithm "SHA1withDSA" used for digital signature.
    public void nonCompliant(final PrivateKey privateKey) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initSign(privateKey);
        signature.update("test data".getBytes());
        signature.sign();
    }
}
// {/fact}