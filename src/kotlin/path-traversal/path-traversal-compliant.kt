// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-path-traversal@v1.0 defects=0}
import java.io.File

// Compliant: Using safe input to access a file path.
fun path_traversal_compliant(filename: String) {
    val file = File(filename)
    val lines = file.readLines()
    for (line in lines) {
        println(line)
    }
}
// {/fact}
