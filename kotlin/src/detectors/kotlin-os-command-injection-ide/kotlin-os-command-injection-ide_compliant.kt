// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-os-command-injection-ide@v1.0 defects=0}
import io.ktor.server.application.*
import java.io.BufferedReader
import java.io.InputStreamReader

fun os_command_injection_compliant(call: ApplicationCall) {
    // Compliant: Validating user input against an allowlist before execution.
    val allowedCommands = setOf("list", "status", "version")
    val userCommand = call.parameters["command"] ?: "list"
    
    if (!allowedCommands.contains(userCommand)) {
        return
    }
    
    val process = Runtime.getRuntime().exec(arrayOf("./script.sh", userCommand))
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val output = reader.readText()
}
// {/fact}
