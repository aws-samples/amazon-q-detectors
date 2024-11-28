// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sql-injection@v1.0 defects=0}

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class SqlInjectionCompliant {

    // Compliant: User-given input is not sanitized before use.
    public void executeSqlStatementCompliant(HttpServletRequest request, java.sql.Connection connection) {
        final String favoriteColor = request.getParameter("favoriteColor");
        try {
            String query = "SELECT * FROM people WHERE favorite_color= ? ";
            PreparedStatement pstmt = connection.prepareStatement( query );
            pstmt.setString( 1, favoriteColor);
            ResultSet results = pstmt.executeQuery( );
            pstmt.execute(query);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
// {/fact}
