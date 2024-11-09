// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-template-injection@v1.0 defects=1}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.apache.velocity.app.Velocity
import org.apache.velocity.VelocityContext
import java.io.StringWriter

object TemplateInjectionNoncompliant {

  def templateInjectionNoncompliant(request: HttpServletRequest, response: HttpServletResponse): String = {
    val userInput = request.getParameter("input")
    val context = new VelocityContext()
    context.put("userInput", userInput)

    // Noncompliant: Directly using unsanitized user input in the template evaluation function.
    val writer = new StringWriter()
    Velocity.evaluate(context, writer, "TemplateInjectionNoncompliant", s"Hello, $userInput")
    writer.toString
  }

}
// {/fact}