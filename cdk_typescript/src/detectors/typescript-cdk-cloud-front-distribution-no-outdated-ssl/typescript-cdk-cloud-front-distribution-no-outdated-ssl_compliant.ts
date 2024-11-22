// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-cloud-front-distribution-no-outdated-ssl@v1.0 defects=0}
import {
  Distribution,
  OriginSslPolicy } from 'aws-cdk-lib/aws-cloudfront';
import { HttpOrigin } from 'aws-cdk-lib/aws-cloudfront-origins';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Uses TLS 1.2, ensuring stronger encryption and security.
    new Distribution(Stack, 'rDistribution2', {
      defaultBehavior: {
        origin: new HttpOrigin('foo.bar.com', {
          originSslProtocols: [OriginSslPolicy.TLS_V1_2]
        })
      }
    });
  }
}
// {/fact}
