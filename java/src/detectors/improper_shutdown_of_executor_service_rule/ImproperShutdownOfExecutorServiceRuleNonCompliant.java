// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-improper-shutdown-of-executor-service@v1.0 defects=1}
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.*;
public class ImproperShutdownOfExecutorServiceRuleNonCompliant {

    private final ExecutorService sharedExecutorService;

    public ImproperShutdownOfExecutorServiceRuleNonCompliant(ExecutorService sharedExecutorService) {
        this.sharedExecutorService = sharedExecutorService;
    }

    // Noncompliant : ExecutorService may not shut down properly in case of an exception.
    void nonCompliant() throws Exception {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            executorService.submit(() -> {});
        } catch(Exception e) {
            throw new Exception("Internal error occurred.",e);
        }
        executorService.shutdown();
    }
}
// {/fact}