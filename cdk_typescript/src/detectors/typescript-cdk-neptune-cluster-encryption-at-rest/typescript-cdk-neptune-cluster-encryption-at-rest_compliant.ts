// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-encryption-at-rest@v1.0 defects=0}
import { CfnDBCluster } from 'aws-cdk-lib/aws-neptune';
import { Stack } from "aws-cdk-lib";
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Enables storage encryption for data security.
    new CfnDBCluster(Stack, 'rDatabaseCluster', { storageEncrypted: true });
  }
}
// {/fact}
