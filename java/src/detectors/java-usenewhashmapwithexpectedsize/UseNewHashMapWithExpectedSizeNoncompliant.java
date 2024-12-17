// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-usenewhashmapwithexpectedsize@v1.0 defects=1}
import java.util.HashMap;
import java.util.Map;

public class UseNewHashMapWithExpectedSizeNoncompliant {

    // Noncompliant: Uses HashMap constructor with initial capacity, potentially causing inefficient rehashing.
    Map<String, Object> nonCompliant(Map<String, Object> parameterMap) {
        Map<String, Object> map = new HashMap<String, Object>(parameterMap.size());
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
// {/fact}
