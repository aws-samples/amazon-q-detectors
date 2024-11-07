// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-defaulthttpclient-deprecated@v1.0 defects=0}
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.SystemDefaultHttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.HttpResponse

// Compliant: `DefaultHttpClient` is not used for setting up HTTP connection.
fun defaulthttpclient_deprecated_compliant() {
    val client: HttpClient = SystemDefaultHttpClient()
    val request: HttpGet = HttpGet("http://google.com")
    val response: HttpResponse= client.execute(request)
}
// {/fact}
