// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-auto-scaling-group-scaling-notifications@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  AutoScalingGroup,
  ScalingEvents
} from 'aws-cdk-lib/aws-autoscaling';
import { Topic } from 'aws-cdk-lib/aws-sns';
import {
  InstanceClass,
  InstanceType,
  MachineImage
} from 'aws-cdk-lib/aws-ec2';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Only configures error events, limiting notification coverage.
    new AutoScalingGroup(Stack, 'rAsg', {
        vpc: new Vpc(Stack, 'rVpc'),
        instanceType: new InstanceType(InstanceClass.T3),
        machineImage: MachineImage.latestAmazonLinux(),
        notifications: [
          {
            scalingEvents: ScalingEvents.ERRORS,
            topic: new Topic(Stack, 'rAsgTopic')
          }
        ]
    });
  }
}
// {/fact}
