// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-zip-unzip-file-path-traversal@v1.0 defects=0}
import better.files._
import scala.io.StdIn

class ZipUnzipCompliant {

  def zipUnzipCompliant(): Unit = {
    val zipPathSecureUnzip: File = getUntrustedZip()
    val destinationPathSecureUnzip = File("out/dest")

    // Compliant: Validate the zip path before unzipping.
    if (isPathWithinTrustedDirectory(zipPathSecureUnzip)) {
      zipPathSecureUnzip.unzipTo(destination = destinationPathSecureUnzip)
    } else {
      println("Error: Invalid zip file path.")
    }
  }

  def getUntrustedZip(): File = {
    println("Please enter the path to the zip file:")
    val userInput = StdIn.readLine()
    File(userInput)
  }

  def isPathWithinTrustedDirectory(zipPath: File): Boolean = {
    val trustedDirectory = File("out/dest")
    zipPath.isChildOf(trustedDirectory)
  }
}
// {/fact}
