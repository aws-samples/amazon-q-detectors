// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sns-topic-ssl-publish-only@v1.0 defects=1}
import {
  PolicyStatement,
  PolicyDocument,
  Effect,
  AnyPrincipal
} from 'aws-cdk-lib/aws-iam';
import { CfnTopicPolicy, Topic } from 'aws-cdk-lib/aws-sns';
import { Stack } from "aws-cdk-lib/core";
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
  super(scope, id, props);
  // Noncompliant: Policy uses `Effect.ALLOW` with `aws:SecureTransport: false` which permits non-SSL connections.
  new Topic(Stack, 'rTopic', { topicName: 'foo' });
  new CfnTopicPolicy(Stack, 'rTopicPolicy', {
    topics: ['foo'],
    policyDocument: new PolicyDocument({
      statements: [
        new PolicyStatement({
          actions: ['sns:publish'],
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
