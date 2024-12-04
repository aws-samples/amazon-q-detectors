// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-rds-instance-backup-enabled@v1.0 defects=0}
import {
CfnDBInstance
} from 'aws-cdk-lib/aws-rds';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);
    // Compliant: Backups enabled (15 days).
    new CfnDBInstance(Stack, 'rDbInstance2', {
      dbInstanceClass: 'db.t3.micro',
      backupRetentionPeriod: 15
    });
	}
}
// {/fact}
