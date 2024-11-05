// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-defaulthttpclient-deprecated@v1.0 defects=1}
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.HttpResponse

// Noncompliant: `DefaultHttpClient` is used for setting up HTTP connection.
fun defaulthttpclient_deprecated_noncompliant() {
    val client: HttpClient = DefaultHttpClient()
    val request: HttpGet = HttpGet("http://google.com")
    val response: HttpResponse= client.execute(request)
}
// {/fact}
