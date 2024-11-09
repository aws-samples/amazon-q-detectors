// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

// {fact rule=typescript-cdk-cognito-user-pool-advanced-security-mode-enforced@v1.0 defects=1}
export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: `advancedSecurityMode` not set to ENFORCED.
        new UserPool(Stack, 'rUserPool');
    }
}
// {/fact}
