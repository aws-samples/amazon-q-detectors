// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-missing-pagination@v1.0 defects=1}
import AWS from 'aws-sdk';

const dynamodb = new AWS.DynamoDB();

async function nonCompliant(lastEvalBackupArn: string, table: string, line: number): Promise<void> {
    // Noncompliant: Doesn't implement pagination logic to handle cases where DynamoDB returns partial results with LastEvaluatedBackupArn token.
    let response = await dynamodb
        .listBackups({
            TableName: table,
            TimeRangeLowerBound: 0,
            TimeRangeUpperBound: line
        })
        .promise();
}
// {/fact}
