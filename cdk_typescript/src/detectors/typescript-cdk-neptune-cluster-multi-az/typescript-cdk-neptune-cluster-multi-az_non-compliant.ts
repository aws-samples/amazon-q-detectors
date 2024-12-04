// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-multi-az@v1.0 defects=1}
import {DatabaseInstance} from 'aws-cdk-lib/aws_rds';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);      
    // Noncompliant: Disables `multiAz`, risking single points of failure and reduced availability.
    new DatabaseInstance(Stack, 'rDatabaseCluster', {
      multiAz: false
    });
	}
}
// {/fact}
