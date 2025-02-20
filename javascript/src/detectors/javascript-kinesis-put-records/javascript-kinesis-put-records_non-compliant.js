// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-kinesis-put-records@v1.0 defects=1}
const AWS = require('aws-sdk');
const kinesis = new AWS.Kinesis({ apiVersion: '2013-12-02', region: 'us-west-2' });

async function nonCompliant() {
    const params = {
        StreamName: 'your-stream-name',
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
        // Noncompliant: A batch request that does not check for failed records, can lead to loss of data.
        const response = await kinesis.putRecords(params).promise();
        console.log('Batch records response:', response);

        console.log('All records sent successfully.');
    } catch (error) {
        console.error('Error sending batch records:', error.message);
    }
}

nonCompliant();
// {/fact}
