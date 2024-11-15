// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-call-executor-not-thread-safe@v1.0 defects=1}
import com.evanlennick.retry4j.CallExecutor;
import com.evanlennick.retry4j.CallExecutorBuilder;
import com.evanlennick.retry4j.config.RetryConfig;

public class CallExecutorNotThreadsafeNoncompliant {
    private  CallExecutor callExecutor;
    // Noncompliant: `CallExecutor` is not thread-safe and should not be shared across multiple threads.
    public void nonCompliant(final RetryConfig retryConfig) {
        callExecutor = new CallExecutorBuilder()
            .config(retryConfig)
            .build();
    }
}
// {/fact}
