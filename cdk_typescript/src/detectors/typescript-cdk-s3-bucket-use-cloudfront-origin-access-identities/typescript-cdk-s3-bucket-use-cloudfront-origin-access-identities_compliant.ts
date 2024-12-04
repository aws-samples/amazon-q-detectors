// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-s3-bucket-use-cloudfront-origin-access-identities@v1.0 defects=0}
import { Stack } from 'aws-cdk-lib';
import { OriginAccessIdentity } from 'aws-cdk-lib/aws-cloudfront';
import {
  Effect,
  PolicyDocument,
  PolicyStatement
} from 'aws-cdk-lib/aws-iam';
import {
  Bucket,
  CfnBucket,
  CfnBucketPolicy,
} from 'aws-cdk-lib/aws-s3';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Uses `OriginAccessIdentity` to restrict bucket access to CloudFront.
    new Bucket(Stack, 'rBucket');
    new CfnBucket(Stack, 'rBucket2', {
      bucketName: 'foo',
      websiteConfiguration: {
        indexDocument: 'index.html',
        errorDocument: 'error.html'
      }
    });
    new CfnBucketPolicy(Stack, 'rPolicy2', {
      bucket: 'foo',
      policyDocument: new PolicyDocument({
        statements: [
          new PolicyStatement({
            actions: ['s3:getobject'],
            effect: Effect.ALLOW,
            principals: [
              new OriginAccessIdentity(Stack, 'rOAI2').grantPrincipal
            ],
            resources: ['arn:aws:s3:::foo', 'arn:aws:s3:::foo/*']
          })
        ]
      })
    });
  }
}
// {/fact}
