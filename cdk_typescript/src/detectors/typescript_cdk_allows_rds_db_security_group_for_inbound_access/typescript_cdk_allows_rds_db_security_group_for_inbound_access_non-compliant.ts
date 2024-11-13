// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-allows-rds-db-security-group-for-inbound-access@v1.0 defects=1}
import {
    CfnDBSecurityGroupIngress
} from 'aws-cdk-lib/aws-rds';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Allows access from all IPs.
        new CfnDBSecurityGroupIngress(Stack, 'rIngress', {
            dbSecurityGroupName: 'foo',
            cidrip: '0.0.0.0/0'
        });
    }
}
// {/fact}
