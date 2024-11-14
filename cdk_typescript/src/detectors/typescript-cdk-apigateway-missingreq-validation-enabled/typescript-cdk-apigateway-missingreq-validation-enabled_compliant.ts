// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-apigateway-missingreq-validation-enabled@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";
import {
  RestApi
} from "aws-cdk-lib/aws-apigateway";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Enables validation for both request body and parameters, improving security.
    const compliantRestApi = new RestApi(Stack, "RestApi");
    compliantRestApi.addRequestValidator("RequestValidator", {
      validateRequestBody: true,
      validateRequestParameters: true
    });
  }
}
// {/fact}
