// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-callawaitterminationonshutdown@v1.0 defects=1}

import java.util.concurrent.ExecutorService;

class SuddenServiceShutdownNoncompliant {

    void shutdownNonCompliant(ExecutorService executorService) throws InterruptedException {
        if (executorService != null) {
            // Noncompliant: `shutdownNow` is called which suddenly shuts down executorService.
            executorService.shutdownNow();
        }
    }
}
// {/fact}
