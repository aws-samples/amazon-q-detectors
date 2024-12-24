// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-missing-pagination@v1.0 defects=1}
const AWS = require('aws-sdk');
const dynamodb = new AWS.DynamoDB();

async function nonCompliant(lastEvalBackupArn, table, line) {
    // Noncompliant: Missing Pagination.
    let response = await dynamodb
        .listBackups({
            TableName: table,
            TimeRangeLowerBound: 0,
            TimeRangeUpperBound: line
        })
        .promise();
}

// {/fact}
