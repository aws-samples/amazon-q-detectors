// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elasticache-missing-redis-authorization@v1.0 defects=0}
import {
  CfnReplicationGroup
} from 'aws-cdk-lib/aws-elasticache';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Uses Secrets Manager for `authToken`.
    new CfnReplicationGroup(Stack, 'rRedisGroup', {
      cacheNodeType: 'cache.t3.micro',
      replicationGroupDescription: 'lorem ipsum dolor sit amet',
      cacheSubnetGroupName: 'lorem',
      transitEncryptionEnabled: true,
      authToken: SecretValue.secretsManager('foo').toString(),
      port: 42
    });
  }
}
// {/fact}
