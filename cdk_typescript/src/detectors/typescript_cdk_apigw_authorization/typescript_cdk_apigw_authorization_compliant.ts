// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-apigw-authorization@v1.0 defects=0}
import {
  AuthorizationType,
  RestApi
  } from 'aws-cdk-lib/aws-apigateway';
  import { Stack } from 'aws-cdk-lib/core';
  import * as cdk from 'aws-cdk-lib';
  
export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);      
    // Compliant: RestApi instantiation sets the `authorizationType` to CUSTOM, enabling authorization.
    new RestApi(Stack, 'rRestApi', {
      defaultMethodOptions: { authorizationType: AuthorizationType.CUSTOM },
    }).root.addMethod('ANY');
  }
} // {/fact}