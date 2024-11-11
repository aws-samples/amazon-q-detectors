// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-jseval@v1.0 defects=1}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import scala.scalajs.js

class JSEvalNoncompliant {

  def jSEvalNoncompliant(request: HttpServletRequest, reponse: HttpServletResponse): Boolean = {
    val code = request.getParameter("code")
    // Noncompliant: `eval` used with unsanitized user input.
    js.eval("console.log(" + code + ")")
    true
  }

}
// {/fact}
