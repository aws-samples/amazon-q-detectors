// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-cognito-user-pool-advanced-security-mode-enforced@v1.0 defects=0}
import {
    CfnUserPool,
} from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: `advancedSecurityMode` set to ENFORCED.
        new CfnUserPool(Stack, 'rUserPool', {
            userPoolAddOns: { advancedSecurityMode: 'ENFORCED' },
        });

    }
}
// {/fact}