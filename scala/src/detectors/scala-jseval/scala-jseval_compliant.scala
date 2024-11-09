// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-jseval@v1.0 defects=0}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.owasp.encoder.Encode
import scala.scalajs.js

class JSEvalCompliant {

  def jSEvalCompliant(request: HttpServletRequest, response: HttpServletResponse): Boolean = {
    val code = request.getParameter("code")
    // Compliant: Sanitizes user input before using it in `eval`, preventing injection attacks.
    val safeCode = Encode.forJavaScript(code)
    js.eval("console.log(" + safeCode + ")")
    true
  }

}
// {/fact}
