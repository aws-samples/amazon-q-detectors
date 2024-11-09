// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-trust-boundary-violation@v1.0 defects=0}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.apache.commons.text.StringEscapeUtils

class TrustBoundaryViolationCompliant {

  def trustBoundaryViolationCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    // Compliant: Sanitize user input to prevent injection attacks.
    val sanitizedInput = StringEscapeUtils.escapeHtml4(input)
    req.getSession.setAttribute(sanitizedInput, "true")
  }

}
// {/fact}
