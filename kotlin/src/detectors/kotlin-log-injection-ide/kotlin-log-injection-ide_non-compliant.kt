// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-log-injection-ide@v1.0 defects=1}
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun noncompliant(request: HttpServletRequest, response: HttpServletResponse) {
    val logger = LoggerFactory.getLogger("SecurityLogger")
    val username = request.getParameter("username")
    
    // Noncompliant: Directly concatenating user input in log messages enables log injection attacks.
    logger.info("User login attempt: " + username)
}
// {/fact}
