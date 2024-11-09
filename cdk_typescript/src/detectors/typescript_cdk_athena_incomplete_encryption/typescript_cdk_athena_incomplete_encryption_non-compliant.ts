// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-athena-incomplete-encryption@v1.0 defects=1}
import { CfnWorkGroup } from 'aws-cdk-lib/aws-athena';
import {Stack} from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    
    // Noncompliant: The CfnWorkGroup instantiation does not set the `workGroupConfiguration` to encrypt the query result.
    new CfnWorkGroup(Stack, 'rWorkgroup', {
      name: 'foo',
    });

  }
}
// {/fact}