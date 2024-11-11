// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-clrf-injection-logs@v1.0 defects=0}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import java.util.logging._

class CrlfInjectionLogsCompliant {

  def crlfInjectionLogsCompliant(req: HttpServletRequest,  resp: HttpServletResponse): Unit = {
    val tainted = req.getParameter("test")
    val logger = Logger.getLogger(this.getClass.getName)
    logger.setLevel(Level.ALL)
    val handler = new ConsoleHandler
    handler.setLevel(Level.ALL)
    logger.addHandler(handler)
    // Compliant: Untrusted data is sanitized before logging.
    val sanitizedTainted = tainted.replaceAll("[\\r\\n]+", "")
    logger.config(sanitizedTainted)
  }

}
// {/fact}
