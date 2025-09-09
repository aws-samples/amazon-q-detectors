// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-crypto-insecure-iv@v1.0 defects=1}
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class CryptoInsecureIVJavaRuleTestCasesNonCompliant {

    private static final Random RANDOM = new Random();

    // Noncompliant: Static, hardcoded IV used for encryption, compromising security by making the cipher predictable.
    public void nonCompliant(SecretKeySpec secretKeySpec, byte[] dataToEncrypt) throws UnsupportedEncodingException {
        byte[] bytesIV = "f618f5679ce969da".getBytes("UTF-8");
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