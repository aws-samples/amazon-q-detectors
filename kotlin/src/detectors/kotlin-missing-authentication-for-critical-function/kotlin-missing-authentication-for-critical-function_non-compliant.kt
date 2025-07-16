// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-missing-authentication-for-critical-function@v1.0 defects=1}
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity

class UserController(private val userService: UserService) {
    
    @DeleteMapping("/users/{id}")
    // Noncompliant: Missing authentication check for critical user deletion operation.
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String> {
        userService.deleteUser(id)
        return ResponseEntity.ok("User deleted successfully")
    }
}
// {/fact}
