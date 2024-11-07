// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-sql-injection@v1.0 defects=0}
using System;
using System.Data.SqlClient;

namespace CSharpInjection.Compliant
{
    class SQLInjection
    {   public void SqlInjectionCompliant()
        {
            using (SqlConnection connection =
                   new SqlConnection("Data Source=(local);Initial Catalog=Northwind;Integrated Security=SSPI;"))
            {
                connection.Open();
                string sql = "SELECT * FROM Customers WHERE EmployeeId = @EmployeeId";
                // Compliant: Obtain a PreparedStatement 'SqlParameter'.
                SqlCommand command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("@EmployeeId", System.Data.SqlDbType.Int));
            }
        }
        static void Main(string[] args)
        {
            SQLInjection sqlInjection = new SQLInjection();
            sqlInjection.SqlInjectionCompliant();
        }
        
    }
}
// {/fact}