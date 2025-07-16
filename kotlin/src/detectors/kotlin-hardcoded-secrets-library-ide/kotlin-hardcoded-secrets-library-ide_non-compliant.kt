// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-hardcoded-secrets-library-ide@v1.0 defects=1}
import java.sql.DriverManager

class DatabaseService {
    
    fun noncompliant() {
        val url = "jdbc:mysql://localhost:3306/mydb"
        val username = "admin"
        
        // Noncompliant: Hardcoded password directly in the source code
        val password = "Password123"
        val connection = DriverManager.getConnection(url, username, password)
    }
}
// {/fact}
