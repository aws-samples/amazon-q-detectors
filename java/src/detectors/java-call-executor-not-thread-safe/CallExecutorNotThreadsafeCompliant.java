// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-call-executor-not-thread-safe@v1.0 defects=0}
import com.evanlennick.retry4j.AsyncCallExecutor;
import com.evanlennick.retry4j.CallExecutorBuilder;
import com.evanlennick.retry4j.config.RetryConfig;

public class CallExecutorNotThreadsafeCompliant {
    private  AsyncCallExecutor callExecutor;
    // Compliant: AsyncCallExecutor is thread-safe and can be safely shared across multiple threads.
    public void compliant(final RetryConfig retryConfig) {
        callExecutor = new CallExecutorBuilder()
            .config(retryConfig)
            .buildAsync();
    }
}
// {/fact}

