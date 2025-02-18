// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-concurrenthashmapatomicityviolationrule@v1.0 defects=1}
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapAtomicityViolationRuleNonCompliant {

    private ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();

    public void nonCompliant(String key) {
        if (concurrentMap.containsKey(key)) {
            // Noncompliant: The key could be removed from the map between the first call and the second one.
            String value = concurrentMap.get(key);
            System.out.println(value.length());
        }
    }

    public void deleteValue(String key) {
        concurrentMap.remove(key);
    }
}
// {/fact}
