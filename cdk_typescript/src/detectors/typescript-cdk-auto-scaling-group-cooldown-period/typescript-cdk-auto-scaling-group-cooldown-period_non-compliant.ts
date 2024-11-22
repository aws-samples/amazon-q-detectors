// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-auto-scaling-group-cooldown-period@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { Stack, Duration } from 'aws-cdk-lib';
import {
  AutoScalingGroup
} from 'aws-cdk-lib/aws-autoscaling';
import {
  InstanceClass,
  InstanceType,
  MachineImage,
  Vpc,
} from 'aws-cdk-lib/aws-ec2';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: No cooldown, leading to potential rapid, uncoordinated scaling.
    new AutoScalingGroup(Stack, 'rAsg', {
      vpc: new Vpc(Stack, 'rVpc'),
      instanceType: new InstanceType(InstanceClass.T3),
      machineImage: MachineImage.latestAmazonLinux(),
      cooldown: Duration.seconds(0)
    });
  }
}
// {/fact}
