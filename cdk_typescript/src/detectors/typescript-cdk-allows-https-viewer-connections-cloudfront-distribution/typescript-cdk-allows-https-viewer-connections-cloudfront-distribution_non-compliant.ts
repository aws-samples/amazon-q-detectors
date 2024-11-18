// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-allows-https-viewer-connections-cloudfront-distribution@v1.0 defects=1}
import {
  OriginSslPolicy,
  Distribution,
} from 'aws-cdk-lib/aws-cloudfront';
import { HttpOrigin, S3Origin } from 'aws-cdk-lib/aws-cloudfront-origins';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Uses insecure `TLS_V1` and `TLS_V1_1` protocols.
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
