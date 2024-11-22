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
    // Compliant: Uses SSL for internal communication, ensuring encrypted traffic within the VPC.
    new LoadBalancer(Stack, 'rELB1', {
        vpc: new Vpc(Stack, 'rVPC'),
      }).addListener({
      internalProtocol: LoadBalancingProtocol.SSL,
      externalPort: 42,
      externalProtocol: LoadBalancingProtocol.SSL
    });
 }
}
// {/fact}
