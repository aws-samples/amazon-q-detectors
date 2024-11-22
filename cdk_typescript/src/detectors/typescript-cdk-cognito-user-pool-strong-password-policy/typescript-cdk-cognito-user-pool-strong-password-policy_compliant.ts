// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-cognito-user-pool-strong-password-policy@v1.0 defects=0}
import { UserPool } from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Enforces a strong password policy with complexity requirements.
    new UserPool(Stack, 'rUserPool', {
      passwordPolicy: {
        minLength: 8,
        requireUppercase: true,
        requireDigits: true,
        requireSymbols: true
      }
    });
  }
}
// {/fact}
