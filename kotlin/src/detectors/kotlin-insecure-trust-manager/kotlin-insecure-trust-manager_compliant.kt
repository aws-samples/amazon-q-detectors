// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-trust-manager@v1.0 defects=0}
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager
import javax.net.ssl.TrustManagerFactory
import java.security.KeyStore

class SecureTrustManager : X509TrustManager {
    // Compliant: Delegating to the default trust manager for proper certificate validation.
    private val defaultTrustManager: X509TrustManager
    
    init {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(null as KeyStore?)
        defaultTrustManager = trustManagerFactory.trustManagers[0] as X509TrustManager
    }
    
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        defaultTrustManager.checkClientTrusted(chain, authType)
    }
    
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        defaultTrustManager.checkServerTrusted(chain, authType)
    }
    
    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return defaultTrustManager.acceptedIssuers
    }
}
// {/fact}
