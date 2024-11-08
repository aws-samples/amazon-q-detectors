// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-api-logging-disabled@v1.0 defects=0}
import * as cdk from "@aws-cdk/core"
import { CfnStage as CfnV2Stage } from "aws-cdk-lib/aws-apigatewayv2"
import { Stack } from "aws-cdk-lib/core"

export class CdkStarterStack extends cdk.Stack {

    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        // Compliant: Logging enabled.
        new CfnV2Stage(Stack, "rStage", {
            accessLogSettings: {
              destinationArn: "foo",
              format: "$context.requestId"
            },
            apiId: "bar",
            stageName: "baz"
          })

    }
}
// {/fact}
