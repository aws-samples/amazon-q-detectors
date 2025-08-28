// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-metrics-factory@v1.0 defects=0}
import com.amazonaws.metrics.MetricsFactory
import org.springframework.stereotype.Component

@Component
class MetricsService {
    // Compliant: Using a singleton instance of MetricsFactory prevents resource exhaustion.
    private val metricsFactory = MetricsFactory()
    
    fun compliant() {
        val metrics = metricsFactory.newMetrics()
        metrics.addCount("RequestProcessed", 1)
    }
}
// {/fact}
