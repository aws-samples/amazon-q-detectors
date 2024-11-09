// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elb-logging-enabled@v1.0 defects=1}
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import { aws_elasticloadbalancing as elb } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib/core';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Noncompliant: Disabled access logging by setting `accessLoggingPolicy` to `false` for Classic Load Balancers.
		new elb.LoadBalancer(Stack, 'rELB', {
			vpc: new Vpc(Stack, 'rVPC'),
			accessLoggingPolicy: {
				s3BucketName: 'foo',
				enabled: false,
			},
		});
	}
}// {/fact}
