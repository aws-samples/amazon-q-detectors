// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-rds-non-default-port@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib/core';
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
	AuroraMysqlEngineVersion,
	DatabaseCluster,
	DatabaseClusterEngine
} from 'aws-cdk-lib/aws-rds';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);
		// Compliant: The DatabaseCluster instantiation sets a custom port value of 42, overriding the default port.
		const vpc = new Vpc(Stack, 'rVpc');
		new DatabaseCluster(Stack, 'rDbCluster', {
			engine: DatabaseClusterEngine.auroraMysql({
				version: AuroraMysqlEngineVersion.VER_5_7_12,
			}),
			instanceProps: { vpc: vpc },
			port: 42,
		});
	}
}
// {/fact}
