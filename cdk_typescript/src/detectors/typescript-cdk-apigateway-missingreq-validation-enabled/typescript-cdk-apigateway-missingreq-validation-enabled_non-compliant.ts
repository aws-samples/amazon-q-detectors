// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-apigateway-missingreq-validation-enabled@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";
import {
  RestApi
} from "aws-cdk-lib/aws-apigateway";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Disables validation, allowing potentially invalid or malicious requests.
    const noncompliantRestApi = new RestApi(Stack, "RestApi");
    noncompliantRestApi.addRequestValidator("RequestValidator", {
      validateRequestBody: false,
      validateRequestParameters: false
    });
  }
}
// {/fact}
