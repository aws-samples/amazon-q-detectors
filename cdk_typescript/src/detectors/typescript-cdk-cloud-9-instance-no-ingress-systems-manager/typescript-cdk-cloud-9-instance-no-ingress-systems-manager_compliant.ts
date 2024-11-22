// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-cloud-9-instance-no-ingress-systems-manager@v1.0 defects=0}
import { CfnEnvironmentEC2 } from 'aws-cdk-lib/aws-cloud9';
import { InstanceType, InstanceClass, InstanceSize } from 'aws-cdk-lib/aws-ec2';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Uses `CONNECT_SSM` for secure, managed connections to the EC2 instance.
    new CfnEnvironmentEC2(Stack, 'rC9Env', {
      instanceType: InstanceType.of(
        InstanceClass.T2,
        InstanceSize.MICRO
      ).toString(),
      connectionType: 'CONNECT_SSM'
    });
  }
}
// {/fact}
