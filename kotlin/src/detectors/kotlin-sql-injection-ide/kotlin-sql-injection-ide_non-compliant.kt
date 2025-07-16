// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-sql-injection-ide@v1.0 defects=1}
import java.sql.Connection
import java.sql.DriverManager
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    private val connection: Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password")
    
    @GetMapping("/user")
    fun getUser(@RequestParam username: String): Map<String, Any> {
        // Noncompliant: Direct concatenation of user input in SQL query enables SQL injection attacks.
        val query = "SELECT * FROM users WHERE username = '$username'"
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery(query)
        
        val result = mutableMapOf<String, Any>()
        if (resultSet.next()) {
            result["id"] = resultSet.getInt("id")
            result["username"] = resultSet.getString("username")
            result["email"] = resultSet.getString("email")
        }
        
        return result
    }
}
// {/fact}
