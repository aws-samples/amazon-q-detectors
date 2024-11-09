// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xxe-trans@v1.0 defects=0}
import javax.xml.transform._
import javax.xml.transform.stream.StreamSource
import javax.xml.XMLConstants
import java.io.StringReader

class XXETransCompliant {

  def xxeTransCompliant(inputXml: String): Unit = {
    val factory = TransformerFactory.newInstance()
    // Compliant: Secure processing enabled and external entity access disabled.
    factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
    factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
    factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "")
    val transformer = factory.newTransformer()
    val source = new StreamSource(new StringReader(inputXml))
    transformer.transform(source, null)
  }

}
// {/fact}
