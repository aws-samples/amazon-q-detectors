// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-callawaitterminationonshutdown@v1.0 defects=0}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class SuddenServiceShutdownCompliant {

    void shutdownCompliant(ExecutorService executorService) throws InterruptedException {
        if (executorService != null) {
            // Compliant: Attempts graceful shutdown before doing so forcefully.
            executorService.shutdown();
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                throw new IllegalStateException("Timed out while waiting for executing threads to terminate");
            }
            executorService.shutdownNow();
        }
    }
}
// {/fact}
