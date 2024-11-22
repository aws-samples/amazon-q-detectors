// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kms-backing-key-rotation-enabled@v1.0 defects=1}
import { Key } from 'aws-cdk-lib/aws-kms';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
	super(scope, id, props);      
	// Noncomplaint: Key rotation is not enabled, reducing security best practices.
	new Key(Stack, 'rSymmetricKey');
  }
}
// {/fact}
