// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-code-injection-ide@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest
import scala.tools.nsc.interpreter.IMain

class CodeInjectionNoncompliant {
  def executeUserCode(request: HttpServletRequest): Any = {
    val codeId = request.getParameter("codeId")
    val interpreter = new IMain()
    
    // Noncompliant: User input is executed as Scala code, allowing arbitrary code execution on the server.
    interpreter.interpret(codeId)
  }
}
// {/fact}
