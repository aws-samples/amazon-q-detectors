// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xpath-injection@v1.0 defects=0}
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathFactory
import scala.io.StdIn.readLine
import org.apache.commons.text.StringEscapeUtils

class XPathInjectionCompliant {

  @throws[Exception]
  def xPathInjectionCompliant(): Unit = {
    println("Enter the XML string:")
    val userInput = readLine()

    val sanitizedInput = StringEscapeUtils.escapeXml11(userInput)

    val df = DocumentBuilderFactory.newInstance
    df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
    df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")
    df.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
    df.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)

    val builder = df.newDocumentBuilder
    val xPathFactory = XPathFactory.newInstance.newXPath
    val xPathExpr = xPathFactory.compile("/xmlhell/text()")

    // Compliant: User input is sanitized before use.
    val result = xPathExpr.evaluate(builder.parse(sanitizedInput))
    println(s"XPath Evaluation result: $result")
  }

}
//{/fact}
