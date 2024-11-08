// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-detect-pbekeyspec-hardcoded-password@v1.0 defect=1}
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class DetectPBEKeySpecHardcodedPasswordNonCompliant {

    // Noncompliant: PBEKeySpec initialized with hardcoded password array, compromising security and making the key predictable.
    void nonCompliant() throws NoSuchAlgorithmException {
        final byte[] salt = new byte[32];
        SecureRandom.getInstanceStrong().nextBytes(salt);
        final PBEKeySpec pbe = new PBEKeySpec(new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'}, salt, 65000, 128);
        pbe.clearPassword();
    }
}
// {/fact}
