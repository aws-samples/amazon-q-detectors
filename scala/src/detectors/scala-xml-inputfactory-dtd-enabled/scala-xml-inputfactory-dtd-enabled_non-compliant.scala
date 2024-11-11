// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xml-inputfactory-dtd-enabled@v1.0 defects=1}
import java.io.FileReader
import javax.xml.stream.XMLInputFactory

class XmlProcessorNoncompliant {

  def xmlProcessorNoncompliant(inputFile: String): Unit = {
    val xmlFactory = XMLInputFactory.newInstance()
    // Noncompliant: No protection against XXE attacks or `DTD` processing.
    val reader = new FileReader(inputFile)
    val xmlReader = xmlFactory.createXMLStreamReader(reader)
  }

}
// {/fact}
