// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-clb-no-inbound-http-https@v1.0 defects=0}
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  LoadBalancer,
  LoadBalancingProtocol,
} from 'aws-cdk-lib/aws-elasticloadbalancing';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: The LoadBalancer uses SSL on port 42, ensuring secure communication.
    const elb2 = new LoadBalancer(Stack, 'rELB', {
        vpc: new Vpc(Stack, 'rVPC')
    });
    elb2.addListener({
      externalPort: 42,
      externalProtocol: LoadBalancingProtocol.SSL
    });
  }
}
// {/fact}
