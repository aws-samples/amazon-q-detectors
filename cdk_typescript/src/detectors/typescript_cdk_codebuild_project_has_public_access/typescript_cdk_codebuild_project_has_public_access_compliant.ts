// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-codebuild-project-has-public-access@v1.0 defects=0}
import * as s3 from '@aws-cdk/aws-s3';
import * as cdk from '@aws-cdk/core';
import * as codebuild from '@aws-cdk/aws-codebuild'
import * as s3 from 'aws-cdk-lib/aws-s3';
import * as cdk from 'aws-cdk-lib';
import * as codebuild from 'aws-cdk-lib/aws-codebuild'

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		const bucket = new s3.Bucket()
		// Compliant: Project instantiation does not set `badge` to `true`, making private resources publicly accessible.
		const privateProject1 = codebuild.Project(this, 'privateProject1', {
			source: codebuild.Source.s3({
				bucket: bucket,
				path: 'path/to/file.zip',
			}),
		})
	}
}
// {/fact}