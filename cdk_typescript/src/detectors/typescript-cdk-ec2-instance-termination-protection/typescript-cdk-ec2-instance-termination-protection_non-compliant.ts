// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-ec2-instance-termination-protection@v1.0 defects=1}
import {
  Instance,
  InstanceClass,
  InstanceType,
  MachineImage,
  Vpc
} from 'aws-cdk-lib/aws-ec2';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Allows API termination, increasing the risk of accidental instance deletion.
    new Instance(Stack, 'rInstance', {vpc: new Vpc(Stack, 'rVpc'),
      instanceType: new InstanceType(InstanceClass.T3),
      machineImage: MachineImage.latestAmazonLinux2()
    });
  }
}
// {/fact}
