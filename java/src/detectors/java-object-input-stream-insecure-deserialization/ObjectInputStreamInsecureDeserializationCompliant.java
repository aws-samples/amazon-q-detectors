// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-object-input-stream-insecure-deserialization@v1.0 defects=0}
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import org.apache.commons.io.serialization.ValidatingObjectInputStream;

public class ObjectInputStreamInsecureDeserializationCompliant {

    // Compliant: Uses ValidatingObjectInputStream to restrict deserialization to allowed classes, mitigating insecure deserialization risks.
    public void compliant(byte[] data, String filterpattern) throws IOException, ClassNotFoundException, IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        final ObjectInputStream objectInputStream = new ValidatingObjectInputStream(byteArrayInputStream);
    }
}
// {/fact}
