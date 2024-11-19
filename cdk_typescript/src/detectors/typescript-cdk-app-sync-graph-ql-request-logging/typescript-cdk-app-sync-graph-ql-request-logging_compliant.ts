// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-app-sync-graph-ql-request-logging@v1.0 defects=0}
import { CfnGraphQLApi } from 'aws-cdk-lib/aws-appsync';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Configures logging with CloudWatch for monitoring API access and invalid requests.
    new CfnGraphQLApi(Stack, 'rGraphqlApi', {
      authenticationType: 'AMAZON_COGNITO_USER_POOL',
      name: 'foo',
      logConfig: { cloudWatchLogsRoleArn: 'foo' }
    });
  }
}
// {/fact}
