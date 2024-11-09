// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-insecure-iv@v1.0 defect=0}
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class CryptoInsecureIVJavaRuleTestCasesCompliant {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static SecureRandom SR;

    // Compliant: Secure random generator used to create a unique IV for each encryption.
    public void compliant(SecretKeySpec secretKeySpec,byte[] dataToEncrypt) {
        SecureRandom random = new SecureRandom();
        byte[] bytesIV = new byte[16];
        random.nextBytes(bytesIV);
        IvParameterSpec iv = new IvParameterSpec(bytesIV);

        GCMParameterSpec params = new GCMParameterSpec(128, bytesIV);

        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, params);
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
// {/fact}