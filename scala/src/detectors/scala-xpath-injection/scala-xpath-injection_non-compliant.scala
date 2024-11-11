// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xpath-injection@v1.0 defects=1}
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath._
import scala.io.StdIn.readLine
import org.apache.commons.text.StringEscapeUtils

class XPathInjectionNoncompliant {

  @throws[Exception]
  def xPathInjectionNoncompliant(): Unit = {
    println("Enter the XML string:")
    val userInput = readLine()

    val df = DocumentBuilderFactory.newInstance
    df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
    df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")
    df.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
    df.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)

    val builder = df.newDocumentBuilder
    val xPathFactory = XPathFactory.newInstance.newXPath
    val xPathExpr = xPathFactory.compile("/xmlhell/text()")

    // Noncompliant: Unsanitized input is used.
    val result = xPathExpr.evaluate(builder.parse(userInput))
    println(s"XPath Evaluation result: $result")
  }

}
//{/fact}
