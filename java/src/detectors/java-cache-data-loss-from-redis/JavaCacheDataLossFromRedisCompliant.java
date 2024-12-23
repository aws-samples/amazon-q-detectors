// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-cache-data-loss-from-redis@v1.0 defects=0}
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.RedisCommandExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaCacheDataLossFromRedisCompliant{
    private static final Logger log = LoggerFactory.getLogger(JavaCacheDataLossFromRedisCompliant.class);

    private void compliant1() {
        RedisAdvancedClusterAsyncCommands<String, ?> async = getRedisAsyncCommands();
        async.multi();
        // Compliant: Flushall executed within a transaction.
        async.flushall(); // This command is part of a transaction
        try {
            async.exec();
        } catch (RedisCommandExecutionException e) {
            log.error("RedisCommandExecutionException is caught.", e);
        }
    }

    private RedisAdvancedClusterAsyncCommands<String, ?> getRedisAsyncCommands() {
        // Implementation details...
        return null;
    }
}
// {/fact}
