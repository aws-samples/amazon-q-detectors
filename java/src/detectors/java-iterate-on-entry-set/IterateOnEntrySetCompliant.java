// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-iterate-on-entry-set@v1.0 defects=0}
import java.util.HashMap;
import java.util.Map;

public class IterateOnEntrySetCompliant {
    // Compliant: Efficiently iterates over `entrySet()`, accessing both keys and values without additional map lookups.
    public void IterateOnEntrySet(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println("Key: " + entry.getKey() +
                    ", Value: " + entry.getValue());
    }
}
// {/fact}
