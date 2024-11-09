// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-os-command-injection@v1.0 defects=1}
import scala.sys.process._
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

class OsCommandInjectionNoncompliant {

  def osCommandInjectionNoncompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val userInput: String = request.getParameter("command")

    // Noncompliant: Directly using user input in OS command execution.
    val result = Seq("sh", "-c", userInput).!!
    println(s"Command output: $result")
  }

}
// {/fact}
