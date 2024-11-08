// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cipherupdateaad@v1.0 defects=1}
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;

public class CipherUpdateAADNonCompliant {

    // Noncompliant: Cipher initialized without using Additional Authenticated Data.
    public byte[] nonCompliant(byte[] key, int tagLength, byte[] ivSource, byte[] salt, byte[] data)
            throws GeneralSecurityException {
        SecretKey secretKeySpec = new SecretKeySpec(key, "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(tagLength, ivSource);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);
        return cipher.doFinal(data);
    }
}
// {/fact}
