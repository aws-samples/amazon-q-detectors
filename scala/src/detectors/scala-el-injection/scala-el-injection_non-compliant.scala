// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-el-injection@v1.0 defects=1}
import javax.el._
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import play.api.mvc._
import javax.inject.Inject

class ElInjectionNoncompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def elInjectionNoncompliant(request: HttpServletRequest, response: HttpServletResponse): String = {
    val userInput = request.getParameter("expression")

    val factory = ExpressionFactory.newInstance()
    val context = new StandardELContext(factory)

    // Noncompliant: Direct use of user input in `EL` expression without sanitization.
    val expression = factory.createValueExpression(context, userInput, classOf[String])

    expression.getValue(context).toString
  }
}
// {/fact}
