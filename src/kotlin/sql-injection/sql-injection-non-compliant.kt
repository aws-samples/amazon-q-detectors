/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-sql-injection@v1.0 defects=1}
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

// Noncompliant: User data is being used in SQL query.
fun sql_injection_noncompliant(connection: Connection): ResultSet {
    print("Enter your userId:")
    val userId = readLine()
    val query = "SELECT * FROM users WHERE userId = '$userId'"
    val statement = connection.createStatement()
    return statement.executeQuery(query)
}
// {/fact}
