// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkreturnvalueofresultsetnext@v1.0 defects=0}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CheckReturnValueOfResultSetNextCompliant {

    public Long compliant(String getCountSqlQuery) throws Exception {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(getCountSqlQuery);
            resultSet = preparedStatement.executeQuery();
            // Compliant: Ensures that the `ResultSet` is non-empty.
            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error reading from db connection and getting count", ex);
        } finally {
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }
    }

    protected abstract Connection connect() throws Exception;
}
// {/fact}
