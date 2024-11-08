// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elb-logging-enabled@v1.0 defects=0}
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  ApplicationLoadBalancer
} from 'aws-cdk-lib/aws-elasticloadbalancingv2';
import { Bucket } from 'aws-cdk-lib/aws-s3';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib/core';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

    // Compliant: Enabled access logging by setting `accessLoggingPolicy` to `true` for Classic Load Balancers.
    const alb = new ApplicationLoadBalancer(Stack, 'rALB', {
        vpc: new Vpc(Stack, 'rVPC'),
      });
    alb.logAccessLogs(new Bucket(Stack, 'rLogsBucket'));
	}
}// {/fact}