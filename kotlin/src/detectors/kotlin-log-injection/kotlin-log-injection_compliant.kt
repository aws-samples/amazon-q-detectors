// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-log-injection@v1.0 defects=0}
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LoggingCompliant {
    companion object {
        private val logger: Logger = LogManager.getLogger()
    }

    // Compliant: Sanitized user data is being written to the logs.
    fun logging_compliant(input: String) {
        logger.info("Value is: {}", input)
    }
}
// {/fact}
