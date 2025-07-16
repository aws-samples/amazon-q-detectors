// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-os-command-injection-ide@v1.0 defects=1}
import io.ktor.server.application.*
import java.io.BufferedReader
import java.io.InputStreamReader

fun os_command_injection_noncompliant(call: ApplicationCall) {
    // Noncompliant: Using unsanitized user input directly in command execution.
    val command = call.parameters["command"] ?: "echo default"
    
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val output = reader.readText()
}
// {/fact}
