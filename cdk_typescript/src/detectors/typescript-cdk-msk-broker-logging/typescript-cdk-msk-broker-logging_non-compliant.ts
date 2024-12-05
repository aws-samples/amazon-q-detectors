// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-msk-broker-logging@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import { CfnCluster } from 'aws-cdk-lib/aws-msk';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Lacks logging configuration, making it harder to monitor and audit the cluster’s activities.
    new CfnCluster(Stack, 'rMsk', {
      clusterName: 'foo',
      kafkaVersion: '2.8.0',
      brokerNodeGroupInfo: {
        clientSubnets: ['bar'],
        instanceType: 'kafka.m5.large',
      },
      numberOfBrokerNodes: 42
    });
  }
}
// {/fact}
