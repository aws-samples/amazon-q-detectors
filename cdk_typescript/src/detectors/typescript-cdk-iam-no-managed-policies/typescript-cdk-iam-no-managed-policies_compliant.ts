// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-iam-no-managed-policies@v1.0 defects=0}
import {
  ManagedPolicy,
  Role,
  AccountRootPrincipal
} from 'aws-cdk-lib/aws-iam';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Uses a restrictive managed policy.
    new Role(Stack, 'rRole', {
      assumedBy: new AccountRootPrincipal(),
      managedPolicies: [ManagedPolicy.fromAwsManagedPolicyName('NotSoPermissivePolicy')]
    });
  }
}
// {/fact}
