// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-missing-pagination@v1.0 defects=0}
async function nonCompliant(lastEvalBackupArn, response, table) {
    while (lastEvalBackupArn !== '') {
        for (let r = 0; r < response.BackupSummaries.length; r++) {
            const record = response.BackupSummaries[r];
            const backupArn = record.BackupArn;
            await dynamodb.deleteBackup({ BackupArn: backupArn }).promise();
            log.info(`Deleted backup for ${table} ${backupArn}`, {
                key: 'deleteBackup',
                table,
                string: backupArn,
                value: record.BackupSizeBytes,
            });
        }

        response = await dynamodb
            .listBackups({
                TableName: table,
                TimeRangeLowerBound: 0,
                TimeRangeUpperBound: line,
                ExclusiveStartBackupArn: lastEvalBackupArn,
            })
            .promise();

        // Compliant: Checks for paginated results.
        if (response.LastEvaluatedBackupArn) {
            lastEvalBackupArn = response.LastEvaluatedBackupArn;
        } else {
            lastEvalBackupArn = '';
        }
    }
}

// {/fact}
