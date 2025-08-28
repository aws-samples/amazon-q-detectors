// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-log-injection-ide@v1.0 defects=0}
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun compliant(request: HttpServletRequest, response: HttpServletResponse) {
    val logger = LoggerFactory.getLogger("SecurityLogger")
    val username = request.getParameter("username")
    
    // Compliant: Using parameterized logging prevents log injection attacks.
    logger.info("User login attempt: {}", username)
}
// {/fact}
