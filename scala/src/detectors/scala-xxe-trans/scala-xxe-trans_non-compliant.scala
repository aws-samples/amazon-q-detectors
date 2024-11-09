// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-xxe-trans@v1.0 defects=1}
import javax.xml.transform._
import javax.xml.transform.stream.StreamSource
import java.io.StringReader

class XXETransNoncompliant {

  def xxeTransNoncompliant(inputXml: String): Unit = {
    // Noncompliant: `FEATURE_SECURE_PROCESSING` is not enabled, and external entities are accessible.
    val factory = TransformerFactory.newInstance()
    val transformer = factory.newTransformer()
    val source = new StreamSource(new StringReader(inputXml))
    transformer.transform(source, null)
  }

}
// {/fact}
