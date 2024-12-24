// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-xxe-in-document-builder-factory@v1.0 defects=1}
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XXEInDocumentBuilderFactoryNoncompliant {

    // Noncompliant: Explicitly allows DOCTYPE declarations, potentially enabling XXE vulnerabilities.
    public void nonCompliant() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
        DocumentBuilder builder = dbf.newDocumentBuilder();
    }
}
// {/fact}
