// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-path-traversal@v1.0 defects=0}
import scala.io.Source
import org.apache.commons.io.FilenameUtils

class PathTraversalCompliant {

  def pathTraversalCompliant() {
    println("Enter a filename:")
    val filename = scala.io.StdIn.readLine()

    // Compliant: Untrusted input is normalized before use.
    val source = Source.fromFile(FilenameUtils.normalize(filename))
    val content = source.getLines().mkString("\n")
    source.close()
  }

}
// {/fact}
