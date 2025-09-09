// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-getrecordswithlimitrule@v1.0 defects=0}
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRecordsWithLimitRuleCompliant {
    private static final Logger log = LoggerFactory.getLogger(GetRecordsWithLimitRuleCompliant.class);

    private final AmazonDynamoDBStreams dynamoDBStreamClient;

    public GetRecordsWithLimitRuleCompliant(AmazonDynamoDBStreams dynamoDBStreamClient) {
        this.dynamoDBStreamClient = dynamoDBStreamClient;
    }

    // Compliant: Use a more conservative, fixed limit instead of stream's batch size . AWS recommends a limit between 1000 and 10000.
    private GetRecordsResult compliant(final String shardIterator) {
        try {
            return dynamoDBStreamClient.getRecords(new GetRecordsRequest()
                    .withShardIterator(shardIterator)
                    .withLimit(1000));
        } catch (ResourceNotFoundException e) {
            log.error(String.format("Encountered an exception while retrieving shard iterator: %s", e.toString()));
            return null;
        }
    }
}
// {/fact}
