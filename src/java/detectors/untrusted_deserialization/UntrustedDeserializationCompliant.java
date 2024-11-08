// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-jacksonunsafedeserialization@v1.0 defects=0}
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class UntrustedDeserializationCompliant {

    // Compliant: ObjectMapper's default typing explicitly deactivated, preventing unsafe deserialization and reducing risk of remote code execution.
    public List compliant(final File input) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.deactivateDefaultTyping();
        return mapper.readValue(input, List.class);
    }
}
// {/fact}