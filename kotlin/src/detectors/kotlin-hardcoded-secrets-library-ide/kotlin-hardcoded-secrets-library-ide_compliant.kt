// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-hardcoded-secrets-library-ide@v1.0 defects=0}
import java.sql.DriverManager

class DatabaseService {
    
    fun compliant() {
        val url = System.getenv("DB_URL")
        val username = System.getenv("DB_USERNAME")
        
        // Compliant: Retrieving password from environment variables instead of hardcoding
        val password = System.getenv("DB_PASSWORD")
        val connection = DriverManager.getConnection(url, username, password)
    }
}
// {/fact}
