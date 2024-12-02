// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-cloud-front-distribution-no-outdated-ssl@v1.0 defects=1}
import {
  Distribution,
  OriginSslPolicy } from 'aws-cdk-lib/aws-cloudfront';
import { HttpOrigin } from 'aws-cdk-lib/aws-cloudfront-origins';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Uses TLS 1.0 and 1.1, which are outdated and less secure.
    new Distribution(Stack, 'rDistribution', {
      defaultBehavior: {
        origin: new HttpOrigin('foo.bar.com', {
          originSslProtocols: [
            OriginSslPolicy.TLS_V1,
            OriginSslPolicy.TLS_V1_1
          ]
        })
      }
    });
  }
}
// {/fact}
