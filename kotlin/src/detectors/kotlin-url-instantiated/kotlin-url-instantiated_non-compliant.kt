// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-url-instantiated@v1.0 defects=1}
import java.net.URL
import java.net.HttpURLConnection

fun url_instantiated_noncompliant() {
    // Noncompliant: Using unencrypted HTTP protocol exposes sensitive data to third parties.
    val url = URL("http://example.com/api/data")
    val connection = url.openConnection() as HttpURLConnection
    val response = connection.inputStream.bufferedReader().use { it.readText() }
}
// {/fact}
