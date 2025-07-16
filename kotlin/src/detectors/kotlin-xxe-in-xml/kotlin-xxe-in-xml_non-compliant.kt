// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-xxe-in-xml@v1.0 defects=1}
import javax.xml.stream.XMLInputFactory
import java.io.InputStream

fun xxe_in_xml_noncompliant(inputStream: InputStream) {
    // Noncompliant: XMLInputFactory without disabling DTD and external entities allows XXE attacks.
    val factory = XMLInputFactory.newFactory()
    val reader = factory.createXMLStreamReader(inputStream)
}
// {/fact}
