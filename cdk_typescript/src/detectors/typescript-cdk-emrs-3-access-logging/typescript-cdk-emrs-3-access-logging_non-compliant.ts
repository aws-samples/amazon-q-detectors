// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-emrs-3-access-logging@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { CfnCluster } from 'aws-cdk-lib/aws-emr';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Missing `logUri`, which prevents logging and makes it harder to monitor the cluster's activities.
    new CfnCluster(Stack, 'rEmrCluster', {
      instances: {},
      jobFlowRole: ' EMR_EC2_DefaultRole',
      name: 'foo',
      serviceRole: 'bar'
    });
  }
}
// {/fact}
