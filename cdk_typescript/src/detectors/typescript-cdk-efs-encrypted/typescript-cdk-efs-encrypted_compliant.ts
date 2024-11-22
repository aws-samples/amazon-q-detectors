// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-efs-encrypted@v1.0 defects=0}
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import { FileSystem } from 'aws-cdk-lib/aws-efs';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Complaint: EFS is created with encryption enabled, ensuring data security at rest.
    new FileSystem(Stack, 'rEFS', {
      vpc: new Vpc(Stack, 'rVpc')
    });
  }
}
// {/fact}
