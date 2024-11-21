// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-usage-of-origin-access-identity-for-cloudfront-distribution@v1.0 defects=1}
import {
    Distribution
} from 'aws-cdk-lib/aws-cloudfront';
import { HttpOrigin } from 'aws-cdk-lib/aws-cloudfront-origins';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncomplaint: Uses an HTTP origin, which may cause security and performance issues.
    new Distribution(Stack, 'rDistribution', {
      defaultBehavior: {
        origin: new HttpOrigin('foo.s3-website.amazonaws.com')
      }
    });
  }
}
// {/fact}
