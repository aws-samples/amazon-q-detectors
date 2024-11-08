// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0


// {fact rule=typescript-cdk-sqs-queue-sse@v1.0 defects=1}
import { Queue, QueueEncryption } from 'aws-cdk-lib/aws-sqs';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);      
   
        // Noncompliant: SQS Queue has server-side encryption disabled.
        new Queue(Stack, 'rQueue', {
            encryption: QueueEncryption.UNENCRYPTED,
        });
	}
}
// {/fact}