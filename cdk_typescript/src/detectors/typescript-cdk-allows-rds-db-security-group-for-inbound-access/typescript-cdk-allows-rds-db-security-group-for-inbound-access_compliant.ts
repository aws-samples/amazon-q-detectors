// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-allows-rds-db-security-group-for-inbound-access@v1.0 defects=0}
import {
  CfnDBSecurityGroupIngress
} from 'aws-cdk-lib/aws-rds';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Restricts access to a specific IP.
    new CfnDBSecurityGroupIngress(Stack, 'rIngress', {
      dbSecurityGroupName: 'foo',
      cidrip: '1.2.3.4/32'
    });
  }
}
// {/fact}
