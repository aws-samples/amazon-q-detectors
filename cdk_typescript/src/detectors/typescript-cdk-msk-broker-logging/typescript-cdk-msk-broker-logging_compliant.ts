// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-msk-broker-logging@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import { CfnCluster } from 'aws-cdk-lib/aws-msk';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Configures logging to S3 and CloudWatch, ensuring proper monitoring and auditing.
    new CfnCluster(Stack, 'rMsk', {
      clusterName: 'foo',
      kafkaVersion: '2.8.0',
      brokerNodeGroupInfo: {
        clientSubnets: ['bar'],
        instanceType: 'kafka.m5.large',
      },
      numberOfBrokerNodes: 42,
      loggingInfo: {
        brokerLogs: {
          s3: { enabled: true, bucket: 'foo' },
          cloudWatchLogs: { enabled: true, logGroup: 'baz' }
        }
      }
    });
  }
}
// {/fact}
