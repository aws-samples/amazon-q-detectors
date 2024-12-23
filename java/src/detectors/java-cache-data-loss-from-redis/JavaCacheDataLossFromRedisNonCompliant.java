// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cache-data-loss-from-redis@v1.0 defects=1}
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;

public class JavaCacheDataLossFromRedisNonCompliant{

    private void nonCompliant1() {
        RedisAdvancedClusterAsyncCommands<String, ?> async = getRedisAsyncCommands();
        // Noncompliant: Flushall executed without transaction.
        async.flushall(); // Flushes all data in the Redis cluster, risking data loss
        async.exec();
    }

    private RedisAdvancedClusterAsyncCommands<String, ?> getRedisAsyncCommands() {
        // Implementation details...
        return null;
    }
}
// {/fact}
