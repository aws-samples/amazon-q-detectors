// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sqs-queue-ssl-requests-only@v1.0 defects=1}
import {
  AnyPrincipal,
  Effect,
  PolicyDocument,
  PolicyStatement
} from 'aws-cdk-lib/aws-iam';
import { CfnQueuePolicy, Queue} from 'aws-cdk-lib/aws-sqs';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);  
    // Noncompliant: Policy uses `Effect.ALLOW` with `aws:SecureTransport: false` which permits non-SSL requests.
    new Queue(Stack, 'rQueue', { queueName: 'foo' });
    new CfnQueuePolicy(Stack, 'rQueuePolicy', {
      queues: ['foo'],
      policyDocument: new PolicyDocument({
        statements: [
          new PolicyStatement({
          actions: ['sqs:*'],
          effect: Effect.ALLOW,
          principals: [new AnyPrincipal()],
          conditions: { Bool: { 'aws:SecureTransport': false } },
          resources: ['foo']
          })
        ]
      }).toJSON()
    });
  }
}
// {/fact}
