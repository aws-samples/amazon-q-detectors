// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-encryption-at-rest@v1.0 defects=0}
import * as s3 from 'monocdk/aws-s3';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: An S3 bucket with a region-specific name (us-east-1).
    const goodBucket = new s3.Bucket(this, 's3-bucket-good-us-east-1')
  }
}
// {/fact}
