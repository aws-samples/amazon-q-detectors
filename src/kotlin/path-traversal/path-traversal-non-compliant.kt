/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-path-traversal@v1.0 defects=1}
import java.io.File

// Noncompliant: Using untrusted inputs to access a file path.
fun path_traversal_noncompliant() {
    print("Enter your filename:")
    val filename = readLine()

    val file = File(filename)
    val lines = file.readLines()
    for (line in lines) {
        println(line)
    }
}
// {/fact}
