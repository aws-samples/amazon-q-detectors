// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-getrecordspaginationrule@v1.0 defects=0}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import lombok.extern.slf4j.Slf4j;
import com.amazonaws.services.dynamodbv2.model.Record;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GetRecordsPaginationCompliant {

    private final AmazonDynamoDBStreams dynamoDBStreams;
    private final AmazonDynamoDBStreams dynamoDBStreamClient;

    public GetRecordsPaginationCompliant(AmazonDynamoDBStreams dynamoDBStreams, AmazonDynamoDBStreams dynamoDBStreamClient) {
        this.dynamoDBStreams = dynamoDBStreams;
        this.dynamoDBStreamClient = dynamoDBStreamClient;
    }
    // Compliant: Implements pagination for `getRecords`, accumulating results and handling rate limiting with Thread.sleep().
    private List<Record> compliant(final String shardIterator, final String info ,final int size) {
        List<Record> resultAccumulator = new ArrayList<>();
        final String endSequenceNumber = info;
        int recordsLimit = size;
        String currShardIterator = shardIterator;
        GetRecordsRequest getRecordsRequest;
        GetRecordsResult getRecordsResult;

        try {
            do {
                getRecordsRequest = new GetRecordsRequest()
                        .withShardIterator(currShardIterator).withLimit(recordsLimit);
                getRecordsResult = dynamoDBStreamClient.getRecords(getRecordsRequest);
                List<Record> newRecords = getRecordsResult.getRecords();
                resultAccumulator.addAll(newRecords);
                currShardIterator = getRecordsResult.getNextShardIterator();
                recordsLimit -= newRecords.size();
                Thread.sleep(1000);
            } while (shouldGetMoreRecords());
        } catch (Exception e) {
            log.error("Encountered an exception while retrieving shard iterator: " + e);
        }
        return resultAccumulator;
    }

    boolean shouldGetMoreRecords(){
        return true;
    }
}
// {/fact}
