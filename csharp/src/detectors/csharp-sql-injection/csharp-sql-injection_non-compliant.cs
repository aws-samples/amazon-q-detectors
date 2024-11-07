// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-sql-injection@v1.0 defects=1}
using System.Data.SqlClient;

namespace CSharpInjection.NonCompliant
{
    class SQLInjection
    {        
        public void SqlInjectionNoncompliant(string sql)
        {
            using (SqlConnection connection = 
                   new SqlConnection("Data Source=(local);Initial Catalog=Northwind;Integrated Security=SSPI;"))
            {
                connection.Open();
                // Noncompliant: Detected a formatted string in a SQL statement.
                SqlCommand command= new SqlCommand(sql, connection);
                command.ExecuteNonQuery();
            }
        }
    }
}
// {/fact}