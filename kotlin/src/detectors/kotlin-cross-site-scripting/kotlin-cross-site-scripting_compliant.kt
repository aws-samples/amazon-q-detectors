// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-cross-site-scripting@v1.0 defects=0}
import java.io.PrintWriter
import org.apache.commons.text.StringEscapeUtils

fun cross_site_scripting_compliant() {
    print("Enter your name:")
    val name = readLine()
    
    // Compliant: Sanitizing user input before rendering it in HTML.
    val sanitizedName = StringEscapeUtils.escapeHtml4(name)
    
    val writer = PrintWriter(System.out)
    writer.write("<p>Hello, $sanitizedName!</p>")
}
// {/fact}
