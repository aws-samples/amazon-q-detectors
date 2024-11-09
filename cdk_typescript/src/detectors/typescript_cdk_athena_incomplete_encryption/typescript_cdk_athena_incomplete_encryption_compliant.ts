// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-athena-incomplete-encryption@v1.0 defects=0}
import { CfnWorkGroup } from 'aws-cdk-lib/aws-athena';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);

		// Compliant: The CfnWorkGroup instantiation sets the `workGroupConfiguration` to encrypt the query result.
		new CfnWorkGroup(this, `${this.roleName}CfnWorkGroup`, {
			name: `${roleName}WorkGroup`,
			recursiveDeleteOption: false,
			state: "ENABLED",
			tags: this.cfnTags,
			workGroupConfiguration: { 
				publishCloudWatchMetricsEnabled: true,
				requesterPaysEnabled: false,
				resultConfiguration: {
				encryptionConfiguration: this.encryptionConfigurationProperty,
				outputLocation: `s3://${this.athenaResultBucket.bucketName}/${roleName}/`,
				},
			},
		});

	}
}
// {/fact}