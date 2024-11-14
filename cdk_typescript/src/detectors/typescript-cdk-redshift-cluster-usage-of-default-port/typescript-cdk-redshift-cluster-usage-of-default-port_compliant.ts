// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-redshift-cluster-usage-of-default-port@v1.0 defects=0}
import { CfnCluster } from 'aws-cdk-lib/aws-redshift';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Compliant: The CfnCluster instantiation sets a custom port value of 42, overriding the default port.
		new CfnCluster(Stack, 'rRedshiftCluster', {
			masterUsername: 'use_a_secret_here',
			masterUserPassword: 'use_a_secret_here',
			clusterType: 'single-node',
			dbName: 'bar',
			nodeType: 'ds2.xlarge',
			port: 42,
		});
	}
}
// {/fact}
