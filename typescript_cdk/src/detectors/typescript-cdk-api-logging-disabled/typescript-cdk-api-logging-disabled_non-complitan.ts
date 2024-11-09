
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-api-logging-disabled@v1.0 defects=1}
import * as cdk from "@aws-cdk/core"
import { CfnStage as CfnV2Stage } from "aws-cdk-lib/aws-apigatewayv2"
import { Stack } from "aws-cdk-lib/core"


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Noncompliant: Logging disabled.
        new CfnV2Stage(Stack, "rHttpApiDefaultStage", {
            apiId: "foo",
            stageName: "baz"
        })

    }
}
// {/fact}
