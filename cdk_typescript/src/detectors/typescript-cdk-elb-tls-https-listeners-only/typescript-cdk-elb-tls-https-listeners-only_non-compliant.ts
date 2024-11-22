// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elb-tls-https-listeners-only@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  LoadBalancer,
  LoadBalancingProtocol
} from 'aws-cdk-lib/aws-elasticloadbalancing';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Uses TCP for internal communication, exposing traffic unencrypted within the VPC.
    new LoadBalancer(Stack, 'rELB', {
        vpc: new Vpc(Stack, 'rVPC'),
      }).addListener({
      internalProtocol: LoadBalancingProtocol.TCP,
      externalPort: 42,
      externalProtocol: LoadBalancingProtocol.SSL
    });
 }
}
// {/fact}
