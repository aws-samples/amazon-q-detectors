// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kinesis-disabled-sse@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import { StreamEncryption, Stream, StreamMode } from 'aws-cdk-lib/aws-kinesis';
import { Duration } from 'aws-cdk-lib';


export class CdkStarterStack extends cdk.Stack {
    public readonly kinesisStream: Stream;
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps, encrypt: boolean) {
      super(scope, id, props);

    // Noncompliant: The Stream sets `encryption` to UNENCRYPTED.
    new Stream(stack, 'rKds', {
        encryption: StreamEncryption.UNENCRYPTED,
    });

 }
}
  
   
// {/fact}