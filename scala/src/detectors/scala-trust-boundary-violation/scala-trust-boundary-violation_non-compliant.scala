// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-trust-boundary-violation@v1.0 defects=1}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

class TrustBoundaryViolationNoncompliant {

  def trustBoundaryViolationNoncompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    // Noncompliant: Unsanitized user input is used here as a session attribute.
    req.getSession.setAttribute(input, "true")
  }

}
// {/fact}
