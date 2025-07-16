// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-xml-decoder@v1.0 defects=1}
import java.io.FileInputStream
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory
import org.xml.sax.helpers.DefaultHandler

class XmlProcessor {
    
    fun processXmlDocument(inputStream: InputStream): org.w3c.dom.Document {
        // Noncompliant: `DocumentBuilderFactory` without security features enabled is vulnerable to XXE attacks.
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        return builder.parse(inputStream)
    }
}
// {/fact}
