// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-concurrenthashmapatomicityviolationrule@v1.0 defects=0}
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapAtomicityViolationRuleCompliant {

    private ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();

    public void compliant(String key) {
        String value = concurrentMap.get(key);
        // Compliant: The value is checked for `null` before being accessed.
        if (value != null) {
            System.out.println(value.length());
        }
    }

    public void deleteValue(String key) {
        concurrentMap.remove(key);
    }
}
// {/fact}
