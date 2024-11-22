// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-auto-scaling-group-health-check@v1.0 defects=0}
import {
  CfnAutoScalingGroup
} from 'aws-cdk-lib/aws-autoscaling';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Uses `EC2` health check, suitable for EC2-based scaling.
    new CfnAutoScalingGroup(Stack, 'rAsg', {
      minSize: '7',
      maxSize: '42',
      healthCheckType: 'EC2'
    });
  }
}
// {/fact}
