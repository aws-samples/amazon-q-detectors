// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kinesis-disabled-sse@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { StreamEncryption, Stream, StreamMode } from 'aws-cdk-lib/aws-kinesis';


export class CdkStarterStack extends cdk.Stack {
	public readonly kinesisStream: Stream;
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps, encrypt: boolean) {
		super(scope, id, props);
		// Compliant: The Stream instantiation sets `encryption` to KMS.
		new Stream(stack, 'rKds', { encryption: StreamEncryption.KMS });
	}
}
// {/fact}