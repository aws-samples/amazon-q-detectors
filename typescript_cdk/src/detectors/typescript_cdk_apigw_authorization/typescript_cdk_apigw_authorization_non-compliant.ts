// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-apigw-authorization@v1.0 defects=1}
import {
  RestApi
  } from 'aws-cdk-lib/aws-apigateway';
  import { Stack } from 'aws-cdk-lib/core';
  import * as cdk from 'aws-cdk-lib';
  
export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);   
        
    // Noncompliant: RestApi instantiation does not set the `authorizationType`, disabling authorization.
    new RestApi(Stack, 'rRestApi').root.addMethod('ANY');
    
  }
} // {/fact}