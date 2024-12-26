// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-getrecordspaginationrule@v1.0 defects=1}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import com.amazonaws.services.dynamodbv2.model.TrimmedDataAccessException;
import com.amazonaws.services.kinesis.model.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetRecordsPaginationNoncompliant {

    private final AmazonDynamoDBStreams dynamoDBStreams;
    private final AmazonDynamoDBStreams dynamoDBStreamClient;


    public GetRecordsPaginationNoncompliant(AmazonDynamoDBStreams dynamoDBStreams, AmazonDynamoDBStreams dynamoDBStreamClient) {
        this.dynamoDBStreams = dynamoDBStreams;
        this.dynamoDBStreamClient = dynamoDBStreamClient;
    }

    // Noncompliant: Doesn't implement pagination for `getRecords`, potentially missing data if more than 1000 records are available.
    private GetRecordsResult nonCompliant(final String shardIterator, String streamInfo) {
        try {
            GetRecordsResult getRecordsResult;
            getRecordsResult = dynamoDBStreamClient.getRecords(new GetRecordsRequest()
                    .withShardIterator(shardIterator)
                    .withLimit(1000));
        } catch (ResourceNotFoundException e) {
            log.error(String.format("Encountered an exception while retrieving shard iterator: %s", e.toString()));
        } catch (TrimmedDataAccessException e) {
            log.error(String.format("Encountered an exception while retrieving shard iterator: %s", e.toString()));
        }
        return null;
    }
}
// {/fact}
