// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-getrecordswithlimitrule@v1.0 defects=1}
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazon.awscanal.stopgapDDB.DDBStreamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRecordsWithLimitRuleNonCompliant {
    private static final Logger log = LoggerFactory.getLogger(GetRecordsWithLimitRuleNonCompliant.class);

    private final AmazonDynamoDBStreams dynamoDBStreamClient;

    public GetRecordsWithLimitRuleNonCompliant(AmazonDynamoDBStreams dynamoDBStreamClient) {
        this.dynamoDBStreamClient = dynamoDBStreamClient;
    }

    // Noncompliant: Batch size from DDB stream as `limit` parameter is used to `GetRecords` which is not recommended.
    private GetRecordsResult nonCompliant(final String shardIterator, final DDBStreamInfo streamInfo) {
        try {
            return dynamoDBStreamClient.getRecords(new GetRecordsRequest()
                    .withShardIterator(shardIterator)
                    .withLimit(streamInfo.getBatchSize()));
        } catch (ResourceNotFoundException e) {
            log.error(String.format("Encountered an exception while retrieving shard iterator: %s", e.toString()));
            throw new Error(String.format("Stream %s no longer exists", streamInfo.getStreamArn()), e);
        }
    }
}
// {/fact}
