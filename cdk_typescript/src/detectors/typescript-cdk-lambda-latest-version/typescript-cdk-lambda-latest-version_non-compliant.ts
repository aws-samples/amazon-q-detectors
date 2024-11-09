// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-lambda-latest-version@v1.0 defects=1}
import { Stack } from 'aws-cdk-lib';
import {
    CfnFunction,
    Runtime
} from 'aws-cdk-lib/aws-lambda';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Latest runtime version is not used.
        new CfnFunction(Stack, 'rFunction', {
            runtime: Runtime.NODEJS_16_X.toString(),
            code: {},
            role: 'somerole'
        });
    }
}

// {/fact}
