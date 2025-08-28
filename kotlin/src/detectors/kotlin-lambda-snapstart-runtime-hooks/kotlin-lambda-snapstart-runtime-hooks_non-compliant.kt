// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-lambda-snapstart-runtime-hooks@v1.0 defects=1}
import org.crac.Resource
import org.crac.Core
import org.crac.Context
import java.sql.Connection
import java.sql.DriverManager

fun noncompliant() {
    val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password")
    
    // Noncompliant: Registering an anonymous object that may be garbage collected.
    Core.getGlobalContext().register(object : Resource {
        override fun beforeCheckpoint(context: Context) {
            connection.close()
        }
    })
}
// {/fact}
