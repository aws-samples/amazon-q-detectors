// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-default-http-client@v1.0 defects=0}
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import java.io.IOException

class DefaultHTTPClientCompliant {

  @throws[IOException]
  def defaultHTTPClientCompliant(): Unit = {
    // Compliant: Using `CloseableHttpClient` instead of `DefaultHttpClient`.
    val client: CloseableHttpClient = HttpClients.createDefault()
    val request = new HttpGet("https://test.com")
    val response = client.execute(request)

    try {
      println("Response received: " + response.getStatusLine)
    } finally {
      response.close()
      client.close()
    }
  }

}
// {/fact}
