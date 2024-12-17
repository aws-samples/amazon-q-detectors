// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-specify-length-when-creating-json-parser@v1.0 defects=0}
import hivemall.utils.io.FastByteArrayInputStream;
import org.apache.hadoop.io.Text;
import org.codehaus.jackson.JsonFactory;
import java.io.IOException;

public class JsonParserCreationUsingFastByteArrayInputStreamCompliant {
    // Compliant: Specifies length when creating JsonParser with FastByteArrayInputStream, improving efficiency.
    void compliant(final Text text) throws IOException {
        new JsonFactory().createJsonParser(new FastByteArrayInputStream(text.getBytes(), text.getLength()));
    }
}
// {/fact}
