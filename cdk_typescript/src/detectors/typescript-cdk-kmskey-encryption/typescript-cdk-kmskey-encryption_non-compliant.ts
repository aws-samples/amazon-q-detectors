// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kmskey-encryption@v1.0 defects=1}
import { BuildSpec, Project } from "aws-cdk-lib/aws-codebuild";
import * as cdk from "@aws-cdk/core";
import { Stack } from "aws-cdk-lib/core";


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        // Noncompliant: The Project instantiation does not set KMS key encryption configuration.
        new Project(Stack, "rBuildProject", {
            buildSpec: BuildSpec.fromObjectToYaml(
                {
                    version: 0.2,
                    phases: {
                        build: { commands: ['echo "foo"'], }
                    }
                }
            )
        });
    }
}
// {/fact}
