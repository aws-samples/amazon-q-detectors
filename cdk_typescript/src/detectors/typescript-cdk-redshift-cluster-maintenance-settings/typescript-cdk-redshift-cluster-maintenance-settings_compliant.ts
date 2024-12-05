// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-redshift-cluster-maintenance-settings@v1.0 defects=0}
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';
import { CfnCluster } from 'aws-cdk-lib/aws-redshift';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);      
    // Compliant: `allowVersionUpgrade: true` enables automatic version upgrades for security and feature updates.
    new CfnCluster(Stack, 'rRedshiftCluster', {
      masterUsername: 'use_a_secret_here',
      masterUserPassword: 'use_a_secret_here',
      clusterType: 'single-node',
      dbName: 'bar',
      nodeType: 'ds2.xlarge',
      allowVersionUpgrade: true,
      preferredMaintenanceWindow: 'Sun:23:45-Mon:00:15'
    });
  }
}
// {/fact}
