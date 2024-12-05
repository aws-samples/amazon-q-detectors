// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-handlecountdownlatchawaittimeouts@v1.0 defects=0}
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MissingTimeoutCheckOnLatchAwaitCompliant {

    private volatile Object result = null;
    private CountDownLatch completionLatch = new CountDownLatch(1);

    // Compliant: Code handles the case when await times out.
    public Object compliant(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException {

        if (!completionLatch.await(timeout, unit)) {
            throw new TimeoutException();
        }
        return result;
    }
}
// {/fact}
