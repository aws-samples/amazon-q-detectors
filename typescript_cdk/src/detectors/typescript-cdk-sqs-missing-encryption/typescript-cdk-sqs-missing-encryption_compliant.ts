    
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sqs-missing-encryption@v1.0 defects=0}
import * as cdk from '@aws-cdk/core';
import * as sqs from '@aws-cdk/aws-sqs';

export class Stack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Queue is encrypted using `QueueEncryption.KMS_MANAGED`.
    const encryptedQueue = new sqs.Queue(this, 'encryptedQueue', {
      encryption: sqs.QueueEncryption.KMS_MANAGED
    })
  }
}
// {/fact}