// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-code-injection-ide@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest
import scala.tools.nsc.interpreter.IMain

class CodeInjectionCompliant {
  def executeUserCode(request: HttpServletRequest): Any = {
    val codeId = request.getParameter("codeId")
    
    if (codeId != null && codeId.matches("^[A-Z0-9]{1,10}$")) {
      val allowedCodes = Set("CALC001", "PRINT001", "TIME001")
      
      if (allowedCodes.contains(codeId)) {
        val codeMap = Map(
          "CALC001" -> "println(math.sqrt(16))",
          "PRINT001" -> "println(\"Safe execution\")",
          "TIME001" -> "println(java.time.LocalDateTime.now())"
        )
        val interpreter = new IMain()
        
        // Compliant: User input is validated and mapped to predefined code, preventing arbitrary code execution.
        interpreter.interpret(codeMap(codeId))
      } else {
        throw new SecurityException("Code ID not allowed")
      }
    } else {
      throw new SecurityException("Invalid code ID format")
    }
  }
}
// {/fact}
