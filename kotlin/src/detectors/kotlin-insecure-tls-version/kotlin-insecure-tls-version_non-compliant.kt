// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-insecure-tls-version@v1.0 defects=1}
import javax.net.ssl.SSLContext
import java.security.NoSuchAlgorithmException

fun noncompliant() {
    try {
        // Noncompliant: Using outdated TLS version 1.1 which has known security vulnerabilities.
        val sslContext = SSLContext.getInstance("TLSv1.1")
        sslContext.init(null, null, null)
        
        val socketFactory = sslContext.socketFactory
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
// {/fact}
