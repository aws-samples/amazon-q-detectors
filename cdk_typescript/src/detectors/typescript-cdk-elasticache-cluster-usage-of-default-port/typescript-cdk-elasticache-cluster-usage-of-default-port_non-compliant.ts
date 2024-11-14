// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elasticache-cluster-usage-of-default-port@v1.0 defects=1}
import {
	CfnCacheCluster,
} from "aws-cdk-lib/aws-elasticache";

import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Noncompliant: The CfnCacheCluster instantiation does not set a custom port value, using the default port instead.
		new CfnCacheCluster(Stack, "rAec", {
			cacheNodeType: "cache.t3.micro",
			engine: "memcached",
			numCacheNodes: 42,
			port: 11211,
		});
	}
}
// {/fact}
