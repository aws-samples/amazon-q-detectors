// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-permissive-cors@v1.0 defects=0}
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse

class PermissiveCorsCompliant extends HttpServlet {

  def permissiveCorsCompliant(resp: HttpServletResponse): Unit = {
    // Compliant: `CORS` policy restricted to specific origin.
    resp.addHeader("Access-Control-Allow-Origin", "http://example.com")
  }

}
// {/fact}
