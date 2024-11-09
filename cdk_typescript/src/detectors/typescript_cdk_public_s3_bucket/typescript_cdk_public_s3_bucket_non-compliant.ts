// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-public-s3-bucket@v1.0 defects=1}
import * as cdk from '@aws-cdk/core';
import * as s3 from '@aws-cdk/aws-s3';
import * as cdk from 'aws-cdk-lib';
import * as s3 from 'aws-cdk-lib/aws-s3';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Bucket has public access which is security sensitive.
    const publicBucket1 = new s3.Bucket(this, 'bucket')
    console.log('something unrelated')
    publicBucket1.grantPublicAccess()

  }
}
// {/fact}