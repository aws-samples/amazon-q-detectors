// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-publicly-accessible-redshift-cluster@v1.0 defects=1}
import { CfnCluster } from 'aws-cdk-lib/aws-redshift';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Exposes the cluster publicly, increasing security risks.
    new CfnCluster(Stack, 'rRedshiftCluster', {
      masterUsername: 'awsuser',
      masterUserPassword: 'use_a_secret_here',
      clusterType: 'single-node',
      dbName: 'bar',
      nodeType: 'ds2.xlarge',
      publiclyAccessible: true
    });
  }
}
// {/fact}
