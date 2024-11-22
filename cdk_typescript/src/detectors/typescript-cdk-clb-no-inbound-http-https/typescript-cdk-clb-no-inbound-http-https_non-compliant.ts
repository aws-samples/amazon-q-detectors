// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-clb-no-inbound-http-https@v1.0 defects=1}
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  LoadBalancer
} from 'aws-cdk-lib/aws-elasticloadbalancing';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: The LoadBalancer uses HTTP on port 80, which is insecure.
    const elb = new LoadBalancer(Stack, 'rELB', {
      vpc: new Vpc(Stack, 'rVPC'),
    });
    elb.addListener({ externalPort: 80 });
  }
}
// {/fact}
