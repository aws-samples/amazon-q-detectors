// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-permissive-cors@v1.0 defects=1}
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse

class PermissiveCorsNoncompliant extends HttpServlet {

  def permissiveCorsNoncompliant(resp: HttpServletResponse): Unit = {
    // Noncompliant: Overly permissive Cross-domain requests accepted.
    resp.addHeader("Access-Control-Allow-Origin", "*")
  }

}
// {/fact}
