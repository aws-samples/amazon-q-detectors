// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkresultofawaitterminationonshutdown@v1.0 defects=1}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.log4j.Log4j;

@Log4j
class MissingTimeoutCheckOnAwaitTerminationNoncompliant {

    // Noncompliant: `awaitTermination` might silently time out before all threads finish their execution.
    public void nonCompliant(ExecutorService executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.warn("Failed to wait for all tasks to finish", e);
        }
    }
}
// {/fact}
