// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-xxe-in-transformerfactory@v1.0 defects=1}
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlExternalEntityNonCompliant {

    // NonCompliant: DocumentBuilder created without disabling external entity processing, potentially allowing XXE attacks.
    public DocumentBuilder nonCompliant(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.parse(inputStream);
        return builder;
    }
}
// {/fact}
