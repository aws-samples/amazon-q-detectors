// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-command-injection@v1.0 defects=1}
// Noncompliant: User input is being passed to `exec`.
fun command_injection_noncompliant() {
    print("Enter your input:")
    val input = readLine()

    val command = "echo Hello, $input"
    val process = Runtime.getRuntime().exec(String.format("The value is: %s", command))
}
// {/fact}
