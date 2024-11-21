// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-zip-unzip-file-path-traversal@v1.0 defects=1}
import better.files._
import scala.io.StdIn

class ZipUnzipNoncompliant {

  def zipUnzipNoncompliant(): Unit = {
    val zipPathVulnerableUnzip: File = getUntrustedZip()
    val destinationPathVulnerableUnzip = File("out/dest")
    // Noncompliant: Directly unzipping without path validation.
    zipPathVulnerableUnzip.unzipTo(destination = destinationPathVulnerableUnzip)
  }

  def getUntrustedZip(): File = {
    println("Please enter the path to the zip file:")
    val userInput = StdIn.readLine()
    File(userInput)
  }

}
// {/fact}
