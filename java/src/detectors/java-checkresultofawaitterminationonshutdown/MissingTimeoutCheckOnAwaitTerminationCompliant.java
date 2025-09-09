// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checkresultofawaitterminationonshutdown@v1.0 defects=0}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.log4j.Log4j;

@Log4j
class MissingTimeoutCheckOnAwaitTerminationCompliant {

    // Compliant: Code handles the case when `awaitTermination` times out.
    public void compliant(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Failed to terminate executor");
            }
        } catch (InterruptedException e) {
            log.warn("Failed to wait for all tasks to finish", e);
        }
    }
}
// {/fact}
