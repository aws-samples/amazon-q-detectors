// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptunedb-database-authentication-disabled@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";
import { CfnDBCluster } from "aws-cdk-lib/aws-neptune";

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Noncompliant: The CfnDBCluster instantiation does not set `iamAuthEnabled`.
		new CfnDBCluster(Stack, "rDatabaseCluster");

	}
}
// {/fact}
