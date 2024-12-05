// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sns-topic-ssl-publish-only@v1.0 defects=0}
import {
    PolicyStatement,
    PolicyDocument,
    Effect,
    StarPrincipal
} from 'aws-cdk-lib/aws-iam';
import { CfnTopicPolicy, Topic } from 'aws-cdk-lib/aws-sns';
import { Stack } from "aws-cdk-lib/core";
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Policy uses `Effect.DENY` with `aws:SecureTransport: false` to explicitly block non-SSL connections.
    new CfnTopicPolicy(Stack, 'rTopicPolicy', {
      topics: ['foo'],
      policyDocument: new PolicyDocument({
      statements: [
        new PolicyStatement({
        actions: ['sns:Publish'],
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
