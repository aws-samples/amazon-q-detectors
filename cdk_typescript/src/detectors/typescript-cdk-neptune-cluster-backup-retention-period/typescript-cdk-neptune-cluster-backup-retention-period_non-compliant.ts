// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-backup-retention-period@v1.0 defects=1}
import { CfnDBCluster } from 'aws-cdk-lib/aws-neptune';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Does not specify `backupRetentionPeriod`, potentially leading to insufficient backup retention
    new CfnDBCluster(Stack, 'rDatabaseCluster');
  }
}
// {/fact}
