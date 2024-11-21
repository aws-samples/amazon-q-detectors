// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kms-backing-key-rotation-enabled@v1.0 defects=0}
import { Key } from 'aws-cdk-lib/aws-kms';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
	super(scope, id, props);        
	// Compliant: Enables key rotation for improved security.
	new Key(Stack, 'rSymmetricKey', { enableKeyRotation: true });
  }
}
// {/fact}
