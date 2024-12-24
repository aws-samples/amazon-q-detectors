// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-batch-write-output-ignored@v1.0 defects=1}
import * as AWS from 'aws-sdk';

const iotanalytics = new AWS.IoTAnalytics();

async function nonCompliant(): Promise<void> {
    const params: AWS.IoTAnalytics.BatchPutMessageRequest = {
        channelName: 'STRING_VALUE',
        messages: [
            {
                messageId: 'STRING_VALUE',
                payload: Buffer.from('...')
            }
        ]
    };

    try {
        // Noncompliant: Ignores the output of `batchPutMessage`, failing to handle potential errors or response data.
        await iotanalytics.batchPutMessage(params).promise();
        console.log("Messages successfully sent");
    } catch (error) {
        console.error("Error sending messages:", error);
    }
}
// {/fact}
