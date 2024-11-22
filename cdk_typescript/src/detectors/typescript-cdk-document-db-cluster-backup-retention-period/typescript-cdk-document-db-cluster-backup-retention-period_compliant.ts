// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-document-db-cluster-backup-retention-period@v1.0 defects=0}
import { DatabaseCluster } from 'aws-cdk-lib/aws-docdb';
import {
  InstanceType,
  InstanceClass,
  InstanceSize,
  Vpc
} from 'aws-cdk-lib/aws-ec2';
import {  Duration, SecretValue, Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);
    // Compliant: Configures backup retention for 7 days, ensuring data recovery.
    new DatabaseCluster(Stack, 'rDatabaseCluster', {
      instanceType: InstanceType.of(InstanceClass.R5, InstanceSize.LARGE),
      vpc: new Vpc(Stack, 'rVpc'),
      backup: { retention: Duration.days(7) },
      masterUser: {
        username: SecretValue.secretsManager('foo').toString(),
        password: SecretValue.secretsManager('bar')
      }
    });
	}
}
// {/fact}
