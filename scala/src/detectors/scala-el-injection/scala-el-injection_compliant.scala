// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-el-injection@v1.0 defects=0}
import javax.el._
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import play.api.mvc._
import javax.inject.Inject
import org.owasp.encoder.Encode

class ElInjectionCompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def elInjectionCompliant(request: HttpServletRequest, response: HttpServletResponse): String = {
    val userInput = request.getParameter("expression")

    // Compliant: Sanitizing user input before using in `EL` expression.
    val sanitizedInput = Encode.forHtml(userInput)

    val factory = ExpressionFactory.newInstance()
    val context = new StandardELContext(factory)

    val expression = factory.createValueExpression(context, sanitizedInput, classOf[String])

    expression.getValue(context).toString
  }
}
// {/fact}
