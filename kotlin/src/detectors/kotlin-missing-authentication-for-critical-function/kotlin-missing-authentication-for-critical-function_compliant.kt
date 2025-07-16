// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-missing-authentication-for-critical-function@v1.0 defects=0}
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize

class UserController(private val userService: UserService) {
    
    @DeleteMapping("/users/{id}")
    // Compliant: Using @PreAuthorize annotation to ensure only admins can delete users.
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String> {
        userService.deleteUser(id)
        return ResponseEntity.ok("User deleted successfully")
    }
}
// {/fact}
