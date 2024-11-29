// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hash-algo-compliance-check-for-pbkdf2@v1.0 defects=0}
import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
public class HashAlgoComplianceCheckForPBKDF2JavaRuleCompliant {
    // Compliant: Strong Algorithm `SHA3-256` is used.
    String compliant() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = System.getenv("password");
        final SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WITHHMACSHA3-256"); //conformant
        final PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), new byte[32], 65000, 128);
        final SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        byte[] hashedBytes = secretKey.getEncoded();
        return Hex.encodeHexString(hashedBytes);
    }
}
// {/fact}
