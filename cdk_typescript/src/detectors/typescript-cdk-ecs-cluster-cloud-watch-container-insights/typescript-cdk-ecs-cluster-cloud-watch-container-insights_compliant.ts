// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-ecs-cluster-cloud-watch-container-insights@v1.0 defects=0}
import {
  Cluster
} from 'aws-cdk-lib/aws-ecs';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant:  Enables container insights for better monitoring and performance tracking.
    new Cluster(Stack, 'rCluster', { containerInsights: true });
  }
}
// {/fact}
