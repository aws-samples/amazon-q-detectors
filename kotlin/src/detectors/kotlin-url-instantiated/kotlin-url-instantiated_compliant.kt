// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-url-instantiated@v1.0 defects=0}
import java.net.URL
import java.net.HttpURLConnection

fun url_instantiated_compliant() {
    // Compliant: Using encrypted HTTPS protocol protects data in transit.
    val url = URL("https://example.com/api/data")
    val connection = url.openConnection() as HttpURLConnection
    val response = connection.inputStream.bufferedReader().use { it.readText() }
}
// {/fact}
