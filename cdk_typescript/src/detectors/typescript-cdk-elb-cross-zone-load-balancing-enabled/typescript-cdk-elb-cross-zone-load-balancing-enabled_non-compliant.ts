// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elb-cross-zone-load-balancing-enabled@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  LoadBalancer
} from 'aws-cdk-lib/aws-elasticloadbalancing';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Disables cross-zone load balancing, reducing fault tolerance.
    new LoadBalancer(Stack, 'rELB', {
      vpc: new Vpc(Stack, 'rVPC'),
      crossZone: false
    });
 }
}
// {/fact}
