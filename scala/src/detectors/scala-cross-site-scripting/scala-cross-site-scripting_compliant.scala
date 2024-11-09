// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-cross-site-scripting@v1.0 defects=0}
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.owasp.encoder.Encode
import java.io.IOException

class CrossSiteScriptingCompliant {

  @throws[ServletException]
  @throws[IOException]
  def crossSiteScriptingCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    // Compliant: Unsanitized input is encoded.
    resp.getWriter.write(Encode.forHtml(input))
  }

}
// {/fact}
