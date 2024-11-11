// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-default-http-client@v1.0 defects=1}
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import java.io.IOException

class DefaultHTTPClientNoncompliant {

  @throws[IOException]
  def defaultHTTPClientNoncompliant(): Unit = {
    // Noncompliant: `DefaultHttpClient` is deprecated.
    val client = new DefaultHttpClient
    val request = new HttpGet("https://test.com")
    client.execute(request)
  }

}
//{/fact}
