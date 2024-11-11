// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-missing-node-to-node-encryption@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import {
	CfnDomain as LegacyCfnDomain
} from 'aws-cdk-lib/aws-elasticsearch';
import { Stack } from 'aws-cdk-lib/core';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Noncompliant: The LegacyCfnDomain instantiation does not set the `nodeToNodeEncryptionOptions`.
		new LegacyCfnDomain(Stack, 'Domain', {});

	}
}
// {/fact}
