// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-tls-version@v1.0 defects=0}
import javax.net.ssl.SSLContext
import java.security.NoSuchAlgorithmException

fun compliant() {
    try {
        // Compliant: Using TLS version 1.2 which provides stronger security and is widely supported.
        val sslContext = SSLContext.getInstance("TLSv1.2")
        sslContext.init(null, null, null)

        val socketFactory = sslContext.socketFactory
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
// {/fact}
