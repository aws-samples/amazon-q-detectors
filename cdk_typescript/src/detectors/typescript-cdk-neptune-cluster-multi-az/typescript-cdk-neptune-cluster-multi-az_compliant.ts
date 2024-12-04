// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-multi-az@v1.0 defects=0}
import {DatabaseInstance} from 'aws-cdk-lib/aws_rds';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);      
    // Compliant: Enables `multiAz`, ensuring high availability and fault tolerance for the database.
    new DatabaseInstance(Stack, 'rDatabaseCluster', {
      multiAz: true
    });
	}
}
// {/fact}
