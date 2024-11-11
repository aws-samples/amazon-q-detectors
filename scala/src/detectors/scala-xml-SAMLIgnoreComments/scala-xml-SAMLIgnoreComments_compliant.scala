// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xml-SAMLIgnoreComments@v1.0 defects=0}
import org.opensaml.xml.parse.BasicParserPool

class IgnoreCommentsCompliant {

  def ignoreCommentsCompliant(): BasicParserPool = {
    val parserPool = new BasicParserPool
    // Compliant: Defining a method to create a parser pool with `ignoreComments` set to `true`.
    parserPool.setIgnoreComments(true)
    parserPool
  }

}
// {/fact}
