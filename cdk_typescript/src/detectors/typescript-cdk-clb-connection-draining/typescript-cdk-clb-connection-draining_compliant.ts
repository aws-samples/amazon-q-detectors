// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-clb-connection-draining@v1.0 defects=0}
import {
  CfnLoadBalancer
} from 'aws-cdk-lib/aws-elasticloadbalancing';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Enables connection draining for graceful termination.
    new CfnLoadBalancer(Stack, 'rCfnElb', {
      listeners: [
        { instancePort: '42', loadBalancerPort: '42', protocol: 'TCP' }
      ],
      connectionDrainingPolicy: { enabled: true }
    });
  }
}
// {/fact}
