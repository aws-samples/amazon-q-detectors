// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elasticache-cluster-usage-of-default-port@v1.0 defects=0}
import {
  CfnCacheCluster,
  CfnReplicationGroup,
} from "aws-cdk-lib/aws-elasticache";

import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // Compliant: The CfnCacheCluster instantiation sets a custom port value of 42, overriding the default port.
    new CfnCacheCluster(Stack, "rAec", {
      cacheNodeType: "cache.t3.micro",
      engine: "memcached",
      numCacheNodes: 42,
      port: 42,
    });
  }
}
// {/fact}