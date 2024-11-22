// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-ec-2-security-group-description@v1.0 defects=1}
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';
import {
  SecurityGroup,
  Vpc
} from 'aws-cdk-lib/aws-ec2';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
	super(scope, id, props);      
    // Noncompliant: Provides an empty description, making it harder to identify the security group’s purpose.
    new SecurityGroup(Stack, 'rSg', {
      vpc: new Vpc(Stack, 'rVpc'),
      description: ' '
    });
  }
}
// {/fact}
