// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-apigw-execution-logging-enabled@v1.0 defects=0}
import {
  MethodLoggingLevel,
  RestApi
} from 'aws-cdk-lib/aws-apigateway';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Enables error logging for better debugging and monitoring.
    new RestApi(Stack, 'rRestApi', {
        deployOptions: { loggingLevel: MethodLoggingLevel.ERROR }
    }).root.addMethod('ANY');
  }
}
// {/fact}
