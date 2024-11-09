// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-os-command-injection@v1.0 defects=0}
import scala.sys.process._
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.google.common.html.HtmlEscapers

class OsCommandInjectionCompliant {

  def osCommandInjectionCompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val userInput: String = request.getParameter("command")

    // Compliant: User input is sanitised before using it in OS command execution.
    val safeInput = HtmlEscapers.htmlEscaper().escape(userInput)
    val result = Seq("sh", "-c", safeInput).!!
    println(s"Command output: $result")
  }

}
// {/fact}
