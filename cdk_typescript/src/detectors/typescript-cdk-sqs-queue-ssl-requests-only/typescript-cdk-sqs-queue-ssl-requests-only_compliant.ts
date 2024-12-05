// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sqs-queue-ssl-requests-only@v1.0 defects=0}
import {
    Effect,
    PolicyDocument,
    PolicyStatement,
    StarPrincipal
} from 'aws-cdk-lib/aws-iam';
import { CfnQueuePolicy } from 'aws-cdk-lib/aws-sqs';
import {  Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);  
    // Compliant: Policy uses `Effect.DENY` with `aws:SecureTransport: false` to block non-SSL requests.
    new CfnQueuePolicy(Stack, 'rQueuePolicy', {
      queues: ['foo'],
      policyDocument: new PolicyDocument({
        statements: [
          new PolicyStatement({
            actions: ['sqs:*'],
            effect: Effect.DENY,
            principals: [new StarPrincipal()],
            conditions: { Bool: { 'aws:SecureTransport': false } },
            resources: ['foo']
          })
        ]
      }).toJSON()
    });
  }
}
// {/fact}
