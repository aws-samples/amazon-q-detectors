// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-unsafe-expr-evaluation@v1.0 defects=1}
import org.apache.commons.jexl3.JexlBuilder
import org.apache.commons.jexl3.JexlEngine
import org.apache.commons.jexl3.MapContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun noncompliant(request: HttpServletRequest, response: HttpServletResponse) {
    // Noncompliant: Using unsanitized user input directly in expression evaluation.
    val userInput = request.getParameter("expr")
    
    val jexl: JexlEngine = JexlBuilder().create()
    val expression = jexl.createExpression(userInput)
    val context = MapContext()
    
    val result = expression.evaluate(context)
    response.writer.write("Result: $result")
}
// {/fact}
