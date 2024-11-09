// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-document-db-cluster-log-exports@v1.0 defects=0}
import { CfnDBCluster } from 'aws-cdk-lib/aws-docdb';
import { SecretValue, Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);      
    
    // Compliant: The CfnDBCluster instantiation sets `enableCloudwatchLogsExports`, enabling authenticate, createIndex, and dropCollection Log Exports.
    new CfnDBCluster(Stack, 'rDatabaseCluster', {
      masterUsername: SecretValue.secretsManager('foo').toString(),
      masterUserPassword: SecretValue.secretsManager('bar').toString(),
      enableCloudwatchLogsExports: [
        'authenticate',
        'createIndex',
        'dropCollection',
      ],
    });
	}
}// {/fact}