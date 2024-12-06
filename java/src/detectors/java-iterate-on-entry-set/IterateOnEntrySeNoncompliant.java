// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-iterate-on-entry-set@v1.0 defects=1}
import java.util.HashMap;
import java.util.Map;

public class IterateOnEntrySeNoncompliant {
    // Noncompliant: Iterates over keySet and uses `map.get()` for each key, which is less efficient than using `entrySet()`.
    public void IterateOnKeySet_UsingValues(Map<String, String> map) {
        for (String name : map.keySet())
            System.out.println("Value: " + map.get(name));
    }
}
// {/fact}
