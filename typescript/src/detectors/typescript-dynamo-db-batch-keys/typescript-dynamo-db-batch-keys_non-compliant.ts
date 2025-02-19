// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-dynamo-db-batch-keys@v1.0 defects=1}
import * as AWS from 'aws-sdk';

const dynamodb = new AWS.DynamoDB();

function compliant(): void {
    const params: AWS.DynamoDB.BatchGetItemInput = {
        RequestItems: {
            MyTable: {
                Keys: [
                    { id: { S: "123" } },
                ],
                ProjectionExpression: "id, attributeName",
            },
        },
    };

    dynamodb.batchGetItem(params, (err: AWS.AWSError, data: AWS.DynamoDB.BatchGetItemOutput) => {
        if (err) {
            console.error("Error occurred:", err);
            return;
        }

        // Noncompliant: Missing check for unprocessed keys
        console.log("Processed query:");
        if (data.Responses) {
            Object.entries(data.Responses).forEach(([tableName, items]) => {
                console.log(`Table: ${tableName}`);
                console.log("Items:", items);
            });
        } else {
            console.log("No data found in the response.");
        }
    });
}
// {/fact}
