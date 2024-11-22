// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-ecs-cluster-cloud-watch-container-insights@v1.0 defects=1}
import {
  Cluster
} from 'aws-cdk-lib/aws-ecs';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Disables container insights, limiting visibility into cluster performance.
    new Cluster(Stack, 'rCluster', { containerInsights: false });
  }
}
// {/fact}
