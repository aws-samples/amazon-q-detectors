// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cross-site-scripting@v1.0 defects=1}
import java.io.PrintWriter

// Noncompliant: Using unsanitized external inputs which leads to XSS.
fun cross_site_scripting_noncompliant() {
    print("Enter your name:")
    val name = readLine()

    val writer = PrintWriter(System.out)
    writer.write("<p>Hello, $name!</p>")
}
// {/fact}
