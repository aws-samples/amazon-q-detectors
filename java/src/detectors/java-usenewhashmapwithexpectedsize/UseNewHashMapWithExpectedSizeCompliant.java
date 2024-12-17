// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-usenewhashmapwithexpectedsize@v1.0 defects=0}
import com.google.common.collect.Maps;
import java.util.Map;

public class UseNewHashMapWithExpectedSizeCompliant {

    // Compliant: Uses Maps.newHashMapWithExpectedSize for efficient HashMap initialization with known size.
    Map<String, Object> compliant(Map<String, Object> parameterMap) {
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(parameterMap.size());
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
// {/fact}
