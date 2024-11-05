// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cross-site-scripting@v1.0 defects=0}
import java.io.PrintWriter

// Compliant: Not using any unsanitized external inputs.
fun cross_site_scripting_compliant() {
    print("Enter your name:")
    val name = readLine()

    val writer = PrintWriter(System.out)
    writer.write("<p>Hello, name!</p>")
}
// {/fact}
