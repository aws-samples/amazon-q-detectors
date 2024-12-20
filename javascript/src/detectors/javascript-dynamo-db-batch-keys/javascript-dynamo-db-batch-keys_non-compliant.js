// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dynamo-db-batch-keys@v1.0 defects=1}
const AWS = require('aws');
const dynamodb = AWS.DynamoDB();

async function nonCompliant() {
    const response = await dynamodb.batchGetItem(batchGetItemParams);

    // Noncompliant: Data integrity is not ensured.
    if(response !== null) {
        console.log("Response receieved");
    }
}
// {/fact}