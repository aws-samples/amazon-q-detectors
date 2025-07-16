// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-unsafe-expr-evaluation@v1.0 defects=0}
import org.apache.commons.jexl3.JexlBuilder
import org.apache.commons.jexl3.JexlEngine
import org.apache.commons.jexl3.MapContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.owasp.esapi.ESAPI
import java.util.regex.Pattern

fun compliant(request: HttpServletRequest, response: HttpServletResponse) {
    // Compliant: Sanitizing user input before using it in expression evaluation.
    val userInput = request.getParameter("expr")
    val sanitizedInput = ESAPI.encoder().encodeForJava(userInput)
    
    val safePattern = Pattern.compile("^[0-9+\\-*/().\\s]*$")
    if (!safePattern.matcher(sanitizedInput).matches()) {
        response.writer.write("Invalid expression")
        return
    }
    
    val jexl: JexlEngine = JexlBuilder().create()
    val expression = jexl.createExpression(sanitizedInput)
    val context = MapContext()
    
    val result = expression.evaluate(context)
    response.writer.write("Result: $result")
}
// {/fact}
