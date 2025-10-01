// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-internet-access-enabled-for-sagemaker-notebook@v1.0 defects=1}
import { Role, ServicePrincipal } from 'aws-cdk-lib/aws-iam';
import {
  CfnNotebookInstance
} from 'aws-cdk-lib/aws-sagemaker';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Enables direct internet access, increasing security risks.
    new CfnNotebookInstance(Stack, 'rNotebook', {
      instanceType: 'ml.t3.xlarge',
      roleArn: new Role(Stack, 'rNotebookRole', {
        assumedBy: new ServicePrincipal('sagemaker.amazonaws.com'),
      }).roleArn,
      subnetId: 'subnet-0bb1c79de3EXAMPLE',
      directInternetAccess: 'Enabled'
    });
  }
}
// {/fact}
