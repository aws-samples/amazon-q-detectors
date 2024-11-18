// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-public-s3-bucket@v1.0 defects=0}
import * as cdk from '@aws-cdk/core';
import * as rename_s3 from '@aws-cdk/aws-s3';
import * as cdk from 'aws-cdk-lib';
import * as rename_s3 from 'aws-cdk-lib/aws-s3';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Compliant: Bucket has public access disabled.
		const nonPublicBucketRenamed = new rename_s3.Bucket(this, 'bucket')

	}
}
// {/fact}
