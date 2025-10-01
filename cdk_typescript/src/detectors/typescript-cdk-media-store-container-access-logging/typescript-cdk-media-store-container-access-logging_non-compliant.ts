// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-media-store-container-access-logging@v1.0 defects=1}
import { CfnContainer } from 'aws-cdk-lib/aws-mediastore';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Access logging is disabled, missing security and auditability.
    new CfnContainer(Stack, 'rMsContainer', {
      containerName: 'foo'
    });
  }
}
// {/fact}
