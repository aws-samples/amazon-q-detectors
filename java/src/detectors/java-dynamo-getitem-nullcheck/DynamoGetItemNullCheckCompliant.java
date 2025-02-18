// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-dynamo-getitem-nullcheck@v1.0 defects=0}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class DynamoGetItemNullCheckCompliant {
    AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().build();

    public void compliant() {
        GetItemRequest request = new GetItemRequest()
                .withTableName("my-table")
                .withKey("my-key");
        try {
            GetItemResult result = dynamoDBClient.getItem(request);
            // Compliant: Added a null check before using `GetItemResult.getItem()` to avoid null pointer exception.
            if (result != null && result.getItem() != null) {
                System.out.println(result.getItem().get("key"));
            }
        } catch (ResourceNotFoundException e) {
            log.error("ResourceNotFoundException is caught.", e);
        }
    }
}
// {/fact}
