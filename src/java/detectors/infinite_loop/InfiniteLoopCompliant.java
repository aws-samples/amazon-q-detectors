// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-infinite-loop-dsl@v1.0 defects=0}
import stubs.ResultClass;
import java.util.concurrent.TimeoutException;

public class InfiniteLoopCompliant {

    // Compliant: Loop has a defined exit condition.
    public String compliant() {
        ResultClass resultClass = new ResultClass();
        for (int i = 0; i < 10; ++i) {
            try {
                String result = resultClass.getResult();
            } catch (TimeoutException e) {
                resultClass.retry();
            }
        }
        return null;
    }
}
// {/fact}
