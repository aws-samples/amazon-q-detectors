// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-dynamo-db-batch-keys@v1.0 defects=0}
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

        // Compliant: Checks for `Unprocessed` keys.
        if (data.UnprocessedKeys && Object.keys(data.UnprocessedKeys).length > 0) {
            console.log("Do something, we still have unprocessed data:", data.UnprocessedKeys);
        } else {
            console.log("We are all done:", data.Responses);
        }
    });
}
// {/fact}
