// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-sql-injection@v1.0 defects=1}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import java.sql.{DriverManager, ResultSet, Statement}

object SqlInjectionNoncompliant {

  def sqlInjectionNoncompliant(request: HttpServletRequest, response: HttpServletResponse): ResultSet = {
    val name = request.getParameter("name")
    val conn = DriverManager.getConnection("jdbc:mysql://localhost:8080", "guest", "password")
    val stmt = conn.createStatement()
    // Noncompliant: Directly using user-provided data in SQL query, leading to SQL injection risk.
    val rs = stmt.executeQuery(s"SELECT * FROM users WHERE username = '$name';")
    rs
  }

}
// {/fact}
