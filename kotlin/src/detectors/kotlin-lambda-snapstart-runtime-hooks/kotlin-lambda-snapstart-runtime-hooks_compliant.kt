// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-lambda-snapstart-runtime-hooks@v1.0 defects=0}
import org.crac.Resource
import org.crac.Core
import org.crac.Context
import java.sql.Connection
import java.sql.DriverManager

class ConnectionResource(private val url: String) : Resource {
    private var connection: Connection? = null
    
    init {
        connection = DriverManager.getConnection(url)
    }
    
    override fun beforeCheckpoint(context: Context) {
        connection?.close()
    }
    
    override fun afterRestore(context: Context) {
        connection = DriverManager.getConnection(url)
    }
}

fun compliant() {
    // Compliant: Using a class-level resource that won't be garbage collected.
    Core.getGlobalContext().register(ConnectionResource("jdbc:mysql://localhost:3306/mydb"))
}
// {/fact}
