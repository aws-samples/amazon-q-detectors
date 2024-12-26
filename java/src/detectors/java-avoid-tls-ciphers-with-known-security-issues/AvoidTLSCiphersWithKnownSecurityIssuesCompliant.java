// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-tls-ciphers-with-known-security-issues@v1.0 defects=0}
import javax.net.ssl.SSLSocket;

public class AvoidTLSCiphersWithKnownSecurityIssuesCompliant {

    // Compliant: Uses a secure TLS cipher suite (TLS_AES_256_GCM_SHA384) without known security issues.
    public void compliant(SSLSocket SSLSocket) {
        String[] suites = new String[] {"TLS_AES_256_GCM_SHA384"};
        SSLSocket.setEnabledCipherSuites(suites);
    }
}
// {/fact}
