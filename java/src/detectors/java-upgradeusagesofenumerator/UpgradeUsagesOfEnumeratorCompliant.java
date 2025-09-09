// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-upgradeusagesofenumerator@v1.0 defects=0}
import javax.servlet.RequestDispatcher;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;

public class UpgradeUsagesOfEnumeratorCompliant {

    protected static final String specials[] =
            { RequestDispatcher.INCLUDE_REQUEST_URI,
                    RequestDispatcher.INCLUDE_CONTEXT_PATH,
                    RequestDispatcher.INCLUDE_SERVLET_PATH,
                    RequestDispatcher.INCLUDE_PATH_INFO,
                    RequestDispatcher.INCLUDE_QUERY_STRING,
                    RequestDispatcher.FORWARD_REQUEST_URI,
                    RequestDispatcher.FORWARD_CONTEXT_PATH,
                    RequestDispatcher.FORWARD_SERVLET_PATH,
                    RequestDispatcher.FORWARD_PATH_INFO,
                    RequestDispatcher.FORWARD_QUERY_STRING };

    protected HashMap<String, Object> attributes =
            new HashMap<String, Object>();
    // Compliant: Using `Collections.enumeration`, which is recommended, as compared to deprecated enumerator.
    public Enumeration<String> compliant() {

        synchronized (attributes) {
            return Collections.enumeration(attributes.keySet());
        }

    }
}
// {/fact}
