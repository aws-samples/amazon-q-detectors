// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-log-injection@v1.0 defects=1}
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import javax.servlet.ServletRequest

class LoggingNoncompliant {
    companion object {
        private val logger: Logger = LogManager.getLogger()
    }
    // Noncompliant: Unsanitized user data is being written to the logs
    fun logging_noncompliant(request: ServletRequest) {
        val xValue = request.getParameter("x")
        logger.info("Value is: {}", xValue)
    }
}
// {/fact}
