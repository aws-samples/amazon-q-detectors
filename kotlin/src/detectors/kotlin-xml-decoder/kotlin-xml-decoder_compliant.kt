// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-xml-decoder@v1.0 defects=0}
import java.io.FileInputStream
import java.io.InputStream
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.SAXParserFactory
import javax.xml.stream.XMLInputFactory
import org.xml.sax.helpers.DefaultHandler

class XmlProcessor {
    
    fun compliant(filePath: String): org.w3c.dom.Document {
        // Compliant: `DocumentBuilderFactory` with security features enabled to prevent XXE attacks.
        val factory = DocumentBuilderFactory.newInstance()
    
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")
        factory.setXIncludeAware(false)
        
        val builder = factory.newDocumentBuilder()
        val inputStream = FileInputStream(filePath)
        return builder.parse(inputStream)
    }
}
// {/fact}
