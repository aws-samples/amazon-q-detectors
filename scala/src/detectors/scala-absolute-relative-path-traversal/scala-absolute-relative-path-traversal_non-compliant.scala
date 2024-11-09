// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-absolute-relative-path-traversal@v1.0 defects=1}
import javax.servlet.ServletException
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import java.io.File
import java.io.IOException

class AbsoluteRelativePathTraversalNoncompliant extends HttpServlet {

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  def absoluteRelativePathTraversalNoncompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    // Noncompliant: Untrusted input from HTTP request is used.
    val filePath = new File(input + "/abs/path")
  }

}
// {/fact}
