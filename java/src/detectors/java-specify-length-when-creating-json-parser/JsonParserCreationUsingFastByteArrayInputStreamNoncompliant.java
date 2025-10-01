// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-specify-length-when-creating-json-parser@v1.0 defects=1}
import hivemall.utils.io.FastByteArrayInputStream;
import org.apache.hadoop.io.Text;
import org.codehaus.jackson.JsonFactory;
import java.io.IOException;

public class JsonParserCreationUsingFastByteArrayInputStreamNoncompliant {

    // Noncompliant: Creates JsonParser without specifying length for FastByteArrayInputStream, potentially causing inefficiency.
    void nonCompliant(final Text text) throws IOException {
        new JsonFactory().createJsonParser(new FastByteArrayInputStream(text.getBytes()));
    }
}
// {/fact}
