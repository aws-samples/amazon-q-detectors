// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jacksonunsafedeserialization@v1.0 defects=1}
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class UntrustedDeserializationNonCompliant {

    // NonCompliant: ObjectMapper's default typing enabled, potentially allowing unsafe deserialization and remote code execution vulnerabilities.
    public List nonCompliant(final File input) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        return mapper.readValue(input, List.class);
    }
}
// {/fact}
