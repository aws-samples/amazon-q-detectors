// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-improper-unicode-normalization@v1.0 defects=1}
import scala.io.StdIn

class ImproperUnicodeNormalizationNoncompliant {

  def improperUnicodeNormalizationNoncompliant(): Unit = {
    println("Enter a string to compare with 'TEST':")
    val input = StdIn.readLine()

    // Noncompliant: Comparison is done without normalizing both strings.
    val result = input.equals("TEST")
    println(s"Comparison result: $result")
  }

}
// {/fact}
