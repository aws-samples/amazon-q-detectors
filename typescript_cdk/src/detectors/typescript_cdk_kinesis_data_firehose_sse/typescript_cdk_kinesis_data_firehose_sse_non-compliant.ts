// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kinesis-data-firehose-sse@v1.0 defects=1}

import { Role, ServicePrincipal } from 'aws-cdk-lib/aws-iam';
import { CfnDeliveryStream } from 'aws-cdk-lib/aws-kinesisfirehose';
import { Bucket } from 'aws-cdk-lib/aws-s3';
import { Stack } from "aws-cdk-lib/core";
import * as cdk from 'aws-cdk-lib';


export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // Noncompliant: The CfnDeliveryStream does not set `deliveryStreamEncFryptionConfigurationInput`
    new CfnDeliveryStream(Stack, 'rKdf', {
      s3DestinationConfiguration: {
        bucketArn: new Bucket(Stack, 'rDeliveryBucket').bucketArn,
        roleArn: new Role(Stack, 'rKdfRole', {
          assumedBy: new ServicePrincipal('firehose.amazonaws.com'),
        }).roleArn,
      },
    });
    
  }
}// {/fact}