// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cipherupdateaad@v1.0 defects=0}
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;

public class CipherUpdateAADCompliant {

    // Compliant: Cipher initialized with additional authenticated data.
    public byte[] compliant(byte[] key, int tagLength, byte[] ivSource, byte[] aad, byte[] data)
            throws GeneralSecurityException {
        SecretKey secretKeySpec = new SecretKeySpec(key, "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(tagLength, ivSource);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);
        cipher.updateAAD(aad);
        return cipher.doFinal(data);
    }
}
// {/fact}
