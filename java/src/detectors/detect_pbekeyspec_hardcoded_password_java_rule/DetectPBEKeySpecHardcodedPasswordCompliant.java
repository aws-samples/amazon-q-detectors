// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-detect-pbekeyspec-hardcoded-password@v1.0 defects=0}
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class DetectPBEKeySpecHardcodedPasswordCompliant{
    private static final String algorithm="SHA256";

    // Compliant: PBEKeySpec initialized with masterKey parameter.
    public byte[] compliant(String masterKey, byte[] salt,int iterations, int keyLen) throws
            Exception{
        String algorithm = "SHA256";
        SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm, BouncyCastleProvider.PROVIDER_NAME);
        KeySpec spec = new PBEKeySpec(masterKey.toCharArray(), salt, iterations, keyLen);
        return factory.generateSecret(spec).getEncoded();
    }
}
// {/fact}