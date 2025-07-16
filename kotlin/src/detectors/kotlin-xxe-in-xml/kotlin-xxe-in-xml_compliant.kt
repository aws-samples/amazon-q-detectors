// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-xxe-in-xml@v1.0 defects=0}
import javax.xml.stream.XMLInputFactory
import java.io.InputStream

fun xxe_in_xml_compliant(inputStream: InputStream) {
    // Compliant: Disabling DTD support and external entities prevents XXE attacks.
    val factory = XMLInputFactory.newFactory()
    factory.setProperty(XMLInputFactory.SUPPORT_DTD, false)
    factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false)
    val reader = factory.createXMLStreamReader(inputStream)
}
// {/fact}
