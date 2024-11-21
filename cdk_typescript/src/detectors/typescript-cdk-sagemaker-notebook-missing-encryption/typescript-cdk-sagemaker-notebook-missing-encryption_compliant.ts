// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sagemaker-notebook-missing-encryption@v1.0 defects=0}
import { Role, ServicePrincipal } from 'aws-cdk-lib/aws-iam';
import {
  CfnNotebookInstance,
} from 'aws-cdk-lib/aws-sagemaker';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Complaint: Specifies a `kmsKeyId` for encryption, securing data at rest.
    new CfnNotebookInstance(Stack, 'rNotebook', {
      instanceType: 'ml.t3.xlarge',
      roleArn: new Role(Stack, 'rNotebookRole', {
        assumedBy: new ServicePrincipal('sagemaker.amazonaws.com'),
      }).roleArn,
      kmsKeyId: '1234abcd-12ab-34cd-56ef-1234567890ab'
    });
  }
}
// {/fact}
