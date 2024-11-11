// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-template-injection@v1.0 defects=0}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.apache.velocity.app.Velocity
import org.apache.velocity.VelocityContext
import org.owasp.encoder.Encode
import java.io.StringWriter

object TemplateInjectionCompliant {

  def templateInjectionCompliant(request: HttpServletRequest, response: HttpServletResponse): String = {
    val userInput = request.getParameter("input")
    val sanitizedInput = Encode.forJava(userInput)

    val context = new VelocityContext()
    context.put("userInput", sanitizedInput)

    // Compliant: Sanitized user input is used in template evaluation function.
    val writer = new StringWriter()
    Velocity.evaluate(context, writer, "TemplateInjectionCompliant", s"Hello, $sanitizedInput")
    writer.toString
  }

}
// {/fact}
