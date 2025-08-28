// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-code-injection-ide@v1.0 defects=1}
import javax.script.ScriptEngineManager
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ScriptExecutor {
    
    fun noncompliant(request: HttpServletRequest, response: HttpServletResponse) {
    
        val userScript = request.getParameter("script")
        
        // Noncompliant: Directly evaluating user input as JavaScript code.
        val engine = ScriptEngineManager().getEngineByName("javascript")
        val result = engine.eval(userScript)
        
        response.writer.write("Script execution result: $result")
    }
}
// {/fact}
