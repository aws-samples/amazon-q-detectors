// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-improper-array-index-check@v1.0 defects=1}
class ImproperArrayIndexCheckNoncompliant {

  def improperArrayIndexCheckNoncompliant(): Unit = {
    val color = "red"
    val strings = List("red", "green")

    // Noncompliant: This overlooks the first element.
    if (strings.indexOf(color) > 0) {
        println("Color not found")
    }
  }

}
// {/fact}
