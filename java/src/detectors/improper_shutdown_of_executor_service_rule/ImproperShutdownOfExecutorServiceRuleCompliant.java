// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-improper-shutdown-of-executor-service@v1.0 defect=0}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ImproperShutdownOfExecutorServiceRuleCompliant {

    // Compliant: ExecutorService has been shut down properly.
    void compliant() {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.shutdown();
    }
}
// {/fact}
