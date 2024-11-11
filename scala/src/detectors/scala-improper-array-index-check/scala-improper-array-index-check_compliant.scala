// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-improper-array-index-check@v1.0 defects=0}
class ImproperArrayIndexCheckCompliant {

  def improperArrayIndexCheckCompliant(): Unit = {
    val color = "red"
    val strings = List("red", "green")

    // Compliant: This does not overlook the first element.
    if (strings.indexOf(color) >= 0) {
        println("Color not found")
    }
  }

}
// {/fact}