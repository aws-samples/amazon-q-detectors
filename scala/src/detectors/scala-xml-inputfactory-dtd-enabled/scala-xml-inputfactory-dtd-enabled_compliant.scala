// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xml-inputfactory-dtd-enabled@v1.0 defects=0}
import java.io.FileReader
import javax.xml.stream.XMLInputFactory

class XmlProcessorCompliant {

  def xmlProcessorCompliant(inputFile: String): Unit = {
    val xmlFactory = XMLInputFactory.newInstance()
    // Compliant: `isSupportingExternalEntities` is set to false.
    xmlFactory.setProperty("javax.xml.stream.isSupportingExternalEntities", false)
    xmlFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false)
    val reader = new FileReader(inputFile)
    val xmlStreamReader = xmlFactory.createXMLStreamReader(reader)
  }

}
// {/fact}
