// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-trust-manager@v1.0 defects=1}
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

class InsecureTrustManager : X509TrustManager {
    // Noncompliant: Empty implementation of trust manager methods accepts any certificate without validation.
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        // No certificate validation performed
    }

    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        // No certificate validation performed
    }

    override fun getAcceptedIssuers(): Array<X509Certificate>? {
        return null
    }
}
// {/fact}
