// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-dynamo-getitem-nullcheck@v1.0 defects=1}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class DynamoGetItemNullCheckNonCompliant {
    AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().build();

    public void nonCompliant() {
        GetItemRequest request = new GetItemRequest()
                .withTableName("my-table")
                .withKey("my-key");
        try {
            GetItemResult result = dynamoDBClient.getItem(request);
            // Noncompliant: `GetItemResult.getItem()` can return null if the item is not found in the database, which may lead to null pointer exceptions.
            System.out.println(result.getItem().get("key"));
        } catch (ResourceNotFoundException e) {
            log.error("ResourceNotFoundException is caught.", e);
        }
    }
}
// {/fact}
