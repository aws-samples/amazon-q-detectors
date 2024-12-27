// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dynamo-db-batch-keys@v1.0 defects=0}
const AWS = require('aws');
const dynamodb = AWS.DynamoDB();

function compliant() {
    dynamodb.batchGetItem({}, (err, data) => {
        // Compliant: Data integrity is ensured.
        if(data.UnprocessedKeys) {
            console.log("Do something, we still have unprocessed data");
        } else {
            console.log("We are all done")
        }
    })
}
// {/fact}
