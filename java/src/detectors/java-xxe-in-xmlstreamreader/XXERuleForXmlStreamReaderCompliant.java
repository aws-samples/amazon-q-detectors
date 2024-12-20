// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-xxe-in-xmlstreamreader@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;

@Slf4j
public abstract class XXERuleForXmlStreamReaderCompliant  {

    // Compliant: Disables both DTD support and external entity processing, effectively preventing XXE attacks.
    public void compliant(InputStream inputStream) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        factory.setProperty("javax.xml.stream.isSupportingExternalEntities", false);
        factory.createXMLStreamReader(inputStream);
    }
}
// {/fact}
