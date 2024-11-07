// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-improper-instantiation-of-bouncy-castle@v1.0 defect=0}
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;

public class ProperInstantiationOfBouncyCastleCompliant {

    // Compliant: `BouncyCastleProvider` properly instantiated and registered as a security provider using `Security.addProvider`.
    public void compliant() {
        BouncyCastleProvider BC_PROVIDER = new BouncyCastleProvider();
        Security.addProvider(BC_PROVIDER);
    }
}
// {/fact}

