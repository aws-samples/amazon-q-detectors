// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-missing-pagination@v1.0 defects=0}
import { DynamoDB } from 'aws-sdk';
import { Logger } from 'some-logging-library';

async function nonCompliant(lastEvalBackupArn: string, response: DynamoDB.ListBackupsOutput, table: string): Promise<void> {
    const dynamodb = new DynamoDB();
    const log = new Logger();
    const line = Date.now();
    while (lastEvalBackupArn !== '') {
        for (const record of response.BackupSummaries || []) {
            const backupArn = record.BackupArn;
            if (backupArn) {
                await dynamodb.deleteBackup({ BackupArn: backupArn }).promise();
                log.info(`Deleted backup for ${table} ${backupArn}`, {
                    key: 'deleteBackup',
                    table,
                    string: backupArn,
                    value: record.BackupSizeBytes,
                });
            }
        }

        response = await dynamodb
            .listBackups({
                TableName: table,
                TimeRangeLowerBound: 0,
                TimeRangeUpperBound: line,
                ExclusiveStartBackupArn: lastEvalBackupArn,
            })
            .promise();

        // Compliant: It properly handles pagination by checking and using LastEvaluatedBackupArn to retrieve all results from DynamoDB listBackups operation.
        if (response.LastEvaluatedBackupArn) {
            lastEvalBackupArn = response.LastEvaluatedBackupArn;
        } else {
            lastEvalBackupArn = '';
        }
    }
}
// {/fact}
