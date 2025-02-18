// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-dynamo-mapper-batch-write-output-ignored@v1.0 defects=0}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.FailedBatch;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DynamoMapperBatchWriteOutputIgnoredCompliant extends DyanmoBatchWriteOutput {
    @Override
    public void compliant(DynamoDBMapperCollection<WriteMessageBatchRequestEntry> batch) {
        List<FailedBatch> failures = myDynamoDBMapper.batchSave(batch);
        // Compliant: Calling a batch operation with handling errors helps prevent to data corruption.
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.error("Logging output {}", failures.getUnprocessedItems(), failures.getException());
        System.out.println("Completed Dynamo Batch Write Operation");
        batch.clear();
    }
}
// {/fact}
