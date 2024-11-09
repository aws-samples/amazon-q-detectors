// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-ecr-open-access@v1.0 defects=0}
import * as cdk from '@aws-cdk/core'
import { Stack } from 'aws-cdk-lib/core'


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Compliant: '*' principals in an ECR Repository is not used.
        new Repository(Stack, 'rRepo')
    }
}
// {/fact}
