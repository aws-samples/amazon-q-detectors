// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-sql-injection@v1.0 defects=0}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import java.sql.{DriverManager, PreparedStatement, ResultSet}

object SqlInjectionCompliant {

  def sqlInjectionCompliant(request: HttpServletRequest, response: HttpServletResponse): ResultSet = {
    val name = request.getParameter("name")
    val conn = DriverManager.getConnection("jdbc:mysql://localhost:8080", "guest", "password")
    // Compliant: Using a prepared statement to handle user input safely, preventing SQL injection.
    val stmt: PreparedStatement = conn.prepareStatement("SELECT * FROM users WHERE username = ?")
    stmt.setString(1, name)
    val rs = stmt.executeQuery()
    rs
  }

}
// {/fact}
