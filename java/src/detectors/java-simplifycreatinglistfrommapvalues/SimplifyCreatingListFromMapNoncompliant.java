// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-simplifycreatinglistfrommapvalues@v1.0 defects=1}
import java.util.stream.Collectors;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import stubs.Item;

public class SimplifyCreatingListFromMapNoncompliant {

    private Map<Long, Map<Long, Item>> machineRules = new ConcurrentHashMap<>(16);
    private Map<Long, Integer> allRules = new ConcurrentHashMap<>(16);

    private static final Integer MAX_RULES_SIZE = 10000;

    // Noncompliant: Uses unnecessary stream and collect operations to create a list from map values, reducing efficiency.
    public List<Item> nonCompliant(Long machineInfo) {
        Map<Long, Item> entities = machineRules.get(machineInfo);
        if (entities == null) {
            return new ArrayList<>();
        }
        return entities.values().stream()
                .collect(Collectors.toList());
    }
}
// {/fact}
