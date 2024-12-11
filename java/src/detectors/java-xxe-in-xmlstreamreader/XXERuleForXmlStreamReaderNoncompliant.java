// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-xxe-in-xmlstreamreader@v1.0 defects=1}
import lombok.extern.slf4j.Slf4j;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;

@Slf4j
public class XXERuleForXmlStreamReaderNoncompliant  {

    // Noncompliant: Disables DTD support but doesn't explicitly disable external entity processing, potentially allowing XXE attacks.
    public void nonCompliant(InputStream inputStream) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        factory.createXMLStreamReader(inputStream);
    }
}
// {/fact}
