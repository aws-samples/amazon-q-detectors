// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-object-input-stream-insecure-deserialization@v1.0 defects=1}
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class ObjectInputStreamInsecureDeserializationNoncompliant {

    // Noncompliant: Creates an ObjectInputFilter but doesn't apply it to the ObjectInputStream, leaving deserialization potentially insecure.
public void nonCompliant(byte[] data, String filterpattern) throws IOException, ClassNotFoundException, IOException {
    try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais)) {
        Object obj = ois.readObject();
    }
}
}
// {/fact}
