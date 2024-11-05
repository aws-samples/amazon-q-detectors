// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-command-injection@v1.0 defects=0}
// Compliant: Hardcoded value is being passed to `exec`.
fun command_injection_compliant() {
    val directory = "hardcoded_value"

    val command = "ls -l " + directory
    val process = Runtime.getRuntime().exec(command)
}
// {/fact}
