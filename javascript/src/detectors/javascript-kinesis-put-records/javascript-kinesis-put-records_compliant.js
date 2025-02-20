// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-kinesis-put-records@v1.0 defects=0}
const AWS = require('aws-sdk');
const kinesis = new AWS.Kinesis({ apiVersion: '2013-12-02', region: 'us-west-2' });

async function compliant() {
    const params = {
        StreamName: 'stream-name',
        Records: [
            {
                Data: JSON.stringify({ key: 'value1' }),
                PartitionKey: 'partitionKey1'
            },
            {
                Data: JSON.stringify({ key: 'value2' }),
                PartitionKey: 'partitionKey2'
            },
            {
                Data: JSON.stringify({ key: 'value3' }),
                PartitionKey: 'partitionKey3'
            }
        ]
    };

    try {
        // Compliant: Handles kinesis `putRecords` errors securely and ensures proper logging of failed records.
        const response = await kinesis.putRecords(params).promise();
        console.log('Batch records response:', response);

        if (response.FailedRecordCount > 0) {
            console.error('Some records failed to send:', response.Records);
        } else {
            console.log('All records sent successfully.');
        }
    } catch (error) {
        console.error('Error sending batch records:', error.message);
    }
}

compliant();
// {/fact}
