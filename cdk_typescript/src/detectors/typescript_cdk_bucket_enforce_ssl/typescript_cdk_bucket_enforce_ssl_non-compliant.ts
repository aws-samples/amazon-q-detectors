// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-bucket-enforce-ssl@v1.0 defects=1}
import * as s3 from "@aws-cdk/aws-s3";
import * as cdk from "@aws-cdk/core";
import * as s3 from "aws-cdk-lib/aws-s3";
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // Noncompliant: The S3 Bucket instantiation does not set `enforceSSL` to `true`.
    const badBucket = new s3.Bucket(this, "s3-bucket-bad");
    
  }
}// {/fact}