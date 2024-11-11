// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-path-traversal@v1.0 defects=1}
import scala.io.Source

class PathTraversalNonCompliant {

  def pathTraversalNonCompliant() {
    println("Enter a filename:")
    val filename = scala.io.StdIn.readLine()

    // Noncompliant: Untrusted input is used without sanitization.
    val source = Source.fromFile(filename)
    val content = source.getLines().mkString("\n")
    source.close()
  }

}
// {/fact}
