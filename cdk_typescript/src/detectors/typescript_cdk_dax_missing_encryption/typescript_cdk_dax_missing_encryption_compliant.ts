// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-dax-missing-encryption@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { CfnCluster } from 'aws-cdk-lib/aws-dax';

export class Stack extends cdk.Stack {
	constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Compliant: The CfnCluster instantiation sets `sseSpecification` property, enabling `sseEnabled` to `true`.
		new CfnCluster(stack, 'rDax', {
			iamRoleArn: new Role(stack, 'rDAXRole', {
				assumedBy: new ServicePrincipal('dax.amazonaws.com'),
			}).roleArn,
			nodeType: 't3.small',
			replicationFactor: 7,
			sseSpecification: { sseEnabled: true },
		});
	}
}// {/fact}