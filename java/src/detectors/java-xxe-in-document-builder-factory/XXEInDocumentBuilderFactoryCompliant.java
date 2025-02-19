// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-xxe-in-document-builder-factory@v1.0 defects=0}
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XXEInDocumentBuilderFactoryCompliant {

    // Compliant: Disables external parameter and general entities to prevent XXE vulnerabilities.
    private void setFeature(DocumentBuilderFactory dbf) throws ParserConfigurationException {
        dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
        dbf.setFeature("foo", true);
        dbf.newDocumentBuilder();
    }
}
// {/fact}
