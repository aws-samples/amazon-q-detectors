// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-insecure-random@v1.0 defects=1}
import scala.util.Random

class InsecureRandomNoncompliant {

  def insecureRandomNoncompliant(): String = {
    // Noncompliant: Using `Random` to generate values is not secure.
    val generatedNumbers = List.fill(16)(Random.nextInt(256))
    generatedNumbers.map("%02x".format(_)).mkString
  }

}
// {/fact}
