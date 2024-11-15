// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-misconfigured-concurrency@v1.0 defects=0}
import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MisconfiguredConcurrencyCompliant  {
    // Compliant: Uses `CompletableFuture` with a timeout in the `get()` method, preventing potential thread blocking issues.
    public void compliant() throws Exception {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        future.get(1, TimeUnit.SECONDS);
    }
}
// {/fact}
