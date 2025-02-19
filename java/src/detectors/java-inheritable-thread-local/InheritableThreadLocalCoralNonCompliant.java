// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-inheritable-thread-local@v1.0 defects=1}
import com.amazon.coral.metrics.Metrics;
import java.lang.InheritableThreadLocal;
import java.lang.ThreadLocal;

public class InheritableThreadLocalCoralNonCompliant {

    public non_compliant() {
        // Noncompliant: Using `InheritableThreadLocal` with async coral clients may accidentally share thread local context with other threads in the thread pool.
        InheritableThreadLocal<Metrics> threadLocalMetrics = new InheritableThreadLocal<>();
    }
}
// {/fact}