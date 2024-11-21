// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-misconfigured-concurrency@v1.0 defects=1}
import java.util.concurrent.CompletableFuture;

public class MisconfiguredConcurrencyNoncompliant {
    // Noncompliant: Uses CompletableFuture's `get()` method without a timeout, potentially causing indefinite blocking.
    public void nonCompliant() throws Exception {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        future.get();
    }
}
// {/fact}

