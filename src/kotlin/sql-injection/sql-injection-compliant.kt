/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-sql-injection@v1.0 defects=0}
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

// Compliant: Hardcoded value is being passed to SQL query.
fun sql_injection_compliant(connection: Connection): ResultSet {
    val userId = "hardcoded_value"
    val query = "SELECT * FROM users WHERE userId = '$userId'"
    val statement = connection.createStatement()
    return statement.executeQuery(query)
}
// {/fact}
