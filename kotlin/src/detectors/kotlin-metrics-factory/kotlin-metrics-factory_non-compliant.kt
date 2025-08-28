// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-metrics-factory@v1.0 defects=1}
import com.amazonaws.metrics.MetricsFactory

fun noncompliant() {
    // Noncompliant: Creating a new MetricsFactory instance for each call leads to resource exhaustion.
    val metricsFactory = MetricsFactory()
    val metrics = metricsFactory.newMetrics()
    metrics.addCount("RequestProcessed", 1)
}
// {/fact}
