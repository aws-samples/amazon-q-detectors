// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-avoid-tls-ciphers@v1.0 defects=1}
import javax.net.ssl.SSLSocket

fun noncompliant() {
    // Noncompliant: Using weak TLS cipher suites with known security vulnerabilities.
    val suites = arrayOf("TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_AES_128_GCM_SHA256")
    SSLSocket.setEnabledCipherSuites(suites)
}
// {/fact}
