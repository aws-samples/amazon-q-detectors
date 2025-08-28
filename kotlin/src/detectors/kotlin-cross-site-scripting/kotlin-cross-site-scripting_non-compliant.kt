// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cross-site-scripting@v1.0 defects=1}
import java.io.PrintWriter

fun cross_site_scripting_noncompliant() {
    print("Enter your name:")
    val name = readLine()
    
    // Noncompliant: Using unsanitized user input directly in HTML output enables XSS attacks.
    val writer = PrintWriter(System.out)
    writer.write("<p>Hello, $name!</p>")
}
// {/fact}
