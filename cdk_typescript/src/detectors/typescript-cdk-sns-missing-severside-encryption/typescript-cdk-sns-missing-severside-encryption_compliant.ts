// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-sns-missing-severside-encryption@v1.0 defects=0}
import { Key } from "aws-cdk-lib/aws-kms";
import { Topic } from "aws-cdk-lib/aws-sns";
import { Stack } from "aws-cdk-lib/core";
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Compliant: SNS topics is encrypted via `masterKey`.
		new Topic(Stack, "rTopic", { masterKey: new Key(Stack, "rKey") });

	}
}
// {/fact}
