// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-backup-retention-period@v1.0 defects=0}
import { CfnDBCluster } from 'aws-cdk-lib/aws-neptune';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Sets `backupRetentionPeriod` to 7 days, ensuring backups are retained for recovery.
    new CfnDBCluster(Stack, 'rDatabaseCluster', {
      backupRetentionPeriod: 7
    });
  }
}
// {/fact}
