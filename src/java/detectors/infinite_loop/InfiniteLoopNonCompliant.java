// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-infinite-loop-dsl@v1.0 defects=1}
import stubs.ResultClass;
import java.util.concurrent.TimeoutException;

public class InfiniteLoopNonCompliant {

    // NonCompliant: Infinite loop without exit condition.
    public String nonCompliant() {
        ResultClass resultClass = new ResultClass();
        for ( ; ; ) {
            try {
                String result = resultClass.getResult();
                return result;
            } catch (TimeoutException e) {
                resultClass.retry();
            }
        }
    }
}
// {/fact}
