// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-neptune-cluster-encryption-at-rest@v1.0 defects=1}
import * as s3 from 'monocdk/aws-s3';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: A bucket without specifying a region in the global resource name, which could lead to naming conflicts across regions.
    const badBucket = new s3.Bucket(this, 's3-bucket-bad', {bucketName: 's3-bucket'})
  }
}
// {/fact}
