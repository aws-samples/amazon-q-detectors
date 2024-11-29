// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sql-injection@v1.0 defects=1}

import javax.servlet.http.HttpServletRequest;

public class SqlInjectionNoncompliant {

    // Noncompliant: User-given input is not sanitized before use.
    public void executeSqlStatementNoncompliant(HttpServletRequest request, java.sql.Connection connection) {
        final String favoriteColor = request.getParameter("favoriteColor");
        try {
            String sql = "SELECT * FROM people WHERE favorite_color='" + favoriteColor + "'";
            java.sql.Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
// {/fact}
