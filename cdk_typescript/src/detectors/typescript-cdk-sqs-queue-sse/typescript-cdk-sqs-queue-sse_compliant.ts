// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0


// {fact rule=typescript-cdk-sqs-queue-sse@v1.0 defects=0}
import { Queue, QueueEncryption } from 'aws-cdk-lib/aws-sqs';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';
import { Key } from 'aws-cdk-lib/aws-kms';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        // Compliant: SQS Queue has server-side encryption enabled.
        new Queue(Stack, 'rQueue', {
            encryptionMasterKey: new Key(Stack, 'rQueueKey'),
        });
    }
}
// {/fact}
