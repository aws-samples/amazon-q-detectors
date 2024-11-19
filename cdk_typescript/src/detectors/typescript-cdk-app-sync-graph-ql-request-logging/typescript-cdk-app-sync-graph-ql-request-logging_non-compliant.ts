// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-app-sync-graph-ql-request-logging@v1.0 defects=1}
import { CfnGraphQLApi } from 'aws-cdk-lib/aws-appsync';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);      
    // Noncomplaint: Missing request-level logging, reducing visibility into API access and usage.
    new CfnGraphQLApi(Stack, 'rGraphqlApi', {
      authenticationType: 'AMAZON_COGNITO_USER_POOL',
      name: 'foo',
      logConfig: { excludeVerboseContent: true }
    });
	}
}
// {/fact}
