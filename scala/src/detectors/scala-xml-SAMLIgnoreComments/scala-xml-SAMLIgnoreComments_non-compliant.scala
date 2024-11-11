// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xml-SAMLIgnoreComments@v1.0 defects=1}
import org.opensaml.xml.parse.BasicParserPool

class IgnoreCommentsNoncompliant {

  def ignoreCommentsNoncompliant(): BasicParserPool = {
    val parserPool = new BasicParserPool
    // Noncompliant: Defining a method to create a parser pool with `ignoreComments` set to `false`.
    parserPool.setIgnoreComments(false)
    parserPool
  }

}
// {/fact}
