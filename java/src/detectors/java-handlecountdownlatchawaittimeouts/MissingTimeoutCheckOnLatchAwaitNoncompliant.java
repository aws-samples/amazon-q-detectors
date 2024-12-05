// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-handlecountdownlatchawaittimeouts@v1.0 defects=1}
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MissingTimeoutCheckOnLatchAwaitNoncompliant {

    private volatile Object result = null;
    private CountDownLatch completionLatch = new CountDownLatch(1);

    // Noncompliant: Code does not check if await timed out or the latch counted down to zero.
    public Object nonCompliant(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException {

        completionLatch.await(timeout, unit);
        return result;
    }
}
// {/fact}
