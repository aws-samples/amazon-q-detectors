// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-paginatedlistperformancerule@v1.0 defects=1}


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.extern.slf4j.Slf4j;
import stubs.Item;
import java.util.ArrayList;

@Slf4j
public class PaginatedListPerformanceNoncompliant  {

    private static DynamoDBMapper mapper;

    // Noncompliant: Uses PaginatedQueryList.size() inside a loop, potentially causing multiple unnecessary DynamoDB queries.
    public void updateTestEntriesNegative(ArrayList<String> input, Item queryKey) {
        input.forEach(keyVal -> {
            DynamoDBQueryExpression<Item> queryExpression = new DynamoDBQueryExpression<Item>()
                    .withConsistentRead(true)
                    .withScanIndexForward(false)
                    .withHashKeyValues(queryKey)
                    .withLimit(1);

            PaginatedQueryList<Item> queryResult = mapper.query(Item.class, queryExpression);
            log.info("got {} items", queryResult.size());
        });
    }
}
// {/fact}
