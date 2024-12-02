// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-untrusted-load@v1.0 defects=0}
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.springframework.web.bind.annotation.RequestParam;
public class UntrustedLoadJavaRuleCompliant {

    // Compliant: Input Stream is validated before deserializing.
    Map<String, String> compliant(@RequestParam String data)
    {
        byte[] byteData = Base64.getDecoder().decode(data);
        try {
            ValidatingObjectInputStream validatingObjectInputstream =
                    new ValidatingObjectInputStream(new ByteArrayInputStream(byteData));
            validatingObjectInputstream.accept(HashMap.class, LinkedHashMap.class);
            Map<String, String> deserializedData = (Map<String, String>) validatingObjectInputstream.readObject();
            validatingObjectInputstream.close();
            return deserializedData;
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Exception in deserializing data", e);
        }
    }
}
// {/fact}
