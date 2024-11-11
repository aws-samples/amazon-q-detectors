// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-redshift-enable-user-activity-logging@v1.0 defects=0}
import { CfnClusterParameterGroup } from 'aws-cdk-lib/aws-redshift';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Compliant: Activity logging is enabled by setting `enable_user_activity_logging` to `true`.
		const compliantParamGroup2 = new CfnClusterParameterGroup(
			Stack,
			'rCfnParameterGroup',
			{
				description: 'foo',
				parameterGroupFamily: 'redshift-1.0',
				parameters: [
					{
						parameterName: 'enable_user_activity_logging',
						parameterValue: 'true',
					},
				],
			});
	}
}
// {/fact}
