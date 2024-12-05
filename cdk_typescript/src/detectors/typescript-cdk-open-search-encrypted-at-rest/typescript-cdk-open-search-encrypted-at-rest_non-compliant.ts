// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-encrypted-at-rest@v1.0 defects=1}
import {
  CfnDomain
} from 'aws-cdk-lib/aws-opensearchservice';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Disables encryption at rest, compromising data security.
    new CfnDomain(Stack, 'Domain', {
      encryptionAtRestOptions: {
        enabled: false
      }
    });
  }
}
// {/fact}
