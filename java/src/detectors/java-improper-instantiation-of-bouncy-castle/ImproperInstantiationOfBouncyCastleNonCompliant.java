// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-improper-instantiation-of-bouncy-castle@v1.0 defects=1}
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;

public class ImproperInstantiationOfBouncyCastleNonCompliant {

    private static final String DEFAULT_ALGORITHM = "HmacSHA256";
    private final String algorithm;

    public ImproperInstantiationOfBouncyCastleNonCompliant() {
        this.algorithm = DEFAULT_ALGORITHM;
    }

    // Noncompliant: BouncyCastleProvider instantiated but not properly registered as a security provider.
    public void nonCompliant() throws Exception{
        BouncyCastleProvider BOUNCY_CASTLE_PROVIDER = new BouncyCastleProvider();
        Signature sig = Signature.getInstance(algorithm, BOUNCY_CASTLE_PROVIDER);
    }
}
// {/fact}

