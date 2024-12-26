// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-tls-ciphers-with-known-security-issues@v1.0 defects=1}
import javax.net.ssl.SSLSocket;

public class AvoidTLSCiphersWithKnownSecurityIssuesNoncompliant {

    // Noncompliant: Uses an anonymous DH cipher suite, which lacks authentication and is vulnerable to man-in-the-middle attacks.
    public void nonCompliant(SSLSocket SSLSocket) {
        String[] suites = new String[] {"TLS_DH_anon_WITH_AES_256_GCM_SHA384"};
        SSLSocket.setEnabledCipherSuites(suites);
    }
}
// {/fact}
