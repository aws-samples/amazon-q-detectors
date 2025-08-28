// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-avoid-tls-ciphers@v1.0 defects=0}
import javax.net.ssl.SSLSocket

fun compliant() {
    // Compliant: Using strong TLS cipher suites that provide secure encryption and authentication.
    val suites = arrayOf("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384")
    SSLSocket.setEnabledCipherSuites(suites)
}
// {/fact}
