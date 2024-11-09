// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-absolute-relative-path-traversal@v1.0 defects=0}
import javax.servlet.ServletException
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import java.io.{File, IOException}
import org.apache.commons.io.FilenameUtils

class AbsoluteRelativePathTraversalCompliant extends HttpServlet {

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  def absoluteRelativePathTraversalCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    val normalizedInput = FilenameUtils.normalize(input)
    val sanitizedInput = FilenameUtils.getName(normalizedInput)
    // Compliant: Extracts only the file name, preventing directory traversal.
    val filePath = new File("/abs/path/" + sanitizedInput)
  }

}
// {/fact}
