// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-code-injection-ide@v1.0 defects=0}
import javax.script.ScriptEngineManager
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.commons.text.StringEscapeUtils

class ScriptExecutor {
    
    fun compliant(request: HttpServletRequest, response: HttpServletResponse) {
        val userInput = request.getParameter("input")
        
        // Compliant: Validate user input against an allowlist of permitted values.
        val allowedInputs = setOf("add(1,2)", "multiply(2,3)", "subtract(5,2)")
        
        if (userInput !in allowedInputs) {
            response.writer.write("Invalid input")
            return
        }
        
        val result = when (userInput) {
            "add(1,2)" -> 3
            "multiply(2,3)" -> 6
            "subtract(5,2)" -> 3
            else -> 0
        }
        
        response.writer.write("Script execution result: $result")
    }
}
// {/fact}
