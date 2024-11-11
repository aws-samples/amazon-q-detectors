// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-improper-unicode-normalization@v1.0 defects=0}
import java.text.Normalizer
import scala.io.StdIn

class ImproperUnicodeNormalizationCompliant {

  def improperUnicodeNormalizationCompliant(): Unit = {

    println("Enter a string to compare with 'TEST':")
    val input = StdIn.readLine()

    // Compliant: Normalize both strings before comparison.
    val normalizedInput = Normalizer.normalize(input, Normalizer.Form.NFKC)
    val normalizedComparison = Normalizer.normalize("TEST", Normalizer.Form.NFKC)

    val result = normalizedInput.equals(normalizedComparison)
    println(s"Comparison result: $result")
  }

}
// {/fact}
