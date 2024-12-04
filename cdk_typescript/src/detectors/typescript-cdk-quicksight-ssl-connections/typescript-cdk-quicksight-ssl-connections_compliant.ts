// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-quicksight-ssl-connections@v1.0 defects=0}
import { CfnDataSource } from 'aws-cdk-lib/aws-quicksight';
import * as cdk from 'aws-cdk-lib';   
import { Stack } from 'aws-cdk-lib';
    
export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);    
    // Compliant: SSL enabled protects data in transit.
    new CfnDataSource(Stack, 'rDashboard', {
      sslProperties: { disableSsl: false }
    });
  }
}
// {/fact}
