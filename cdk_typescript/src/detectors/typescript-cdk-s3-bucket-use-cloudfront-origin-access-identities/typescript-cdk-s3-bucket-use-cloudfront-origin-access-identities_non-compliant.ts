// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-s3-bucket-use-cloudfront-origin-access-identities@v1.0 defects=1}
import { Stack } from 'aws-cdk-lib';
import {
  CfnBucket
} from 'aws-cdk-lib/aws-s3';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Does not use `OriginAccessIdentity`, potentially exposing the bucket publicly.
    new CfnBucket(Stack, 'rBucket', {
      websiteConfiguration: {
        indexDocument: 'index.html',
        errorDocument: 'error.html'
      }
    });
  }
}
// {/fact}
