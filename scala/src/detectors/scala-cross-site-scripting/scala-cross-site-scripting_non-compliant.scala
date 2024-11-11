// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cross-site-scripting@v1.0 defects=1}
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class CrossSiteScriptingNoncompliant {

  @throws[ServletException]
  @throws[IOException]
  def crossSiteScriptingNoncompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    // Noncompliant: Server response uses potentially unsanitized data.
    resp.getWriter.write(input)
  }

}
// {/fact}
