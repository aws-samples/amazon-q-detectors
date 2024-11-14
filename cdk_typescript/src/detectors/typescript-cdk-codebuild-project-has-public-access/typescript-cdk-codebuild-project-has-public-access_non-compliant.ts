// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-codebuild-project-has-public-access@v1.0 defects=1}
import * as cdk from '@aws-cdk/core';
import * as codebuild from '@aws-cdk/aws-codebuild'
import * as cdk from 'aws-cdk-lib';
import * as codebuild from 'aws-cdk-lib/aws-codebuild'


export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Noncompliant: Project instantiation sets `badge` to `true`, making private resources publicly accessible.
		const publicProject1 = new codebuild.Project(this, 'publicProject', {
			badge: true
		})
	}
}
// {/fact}
