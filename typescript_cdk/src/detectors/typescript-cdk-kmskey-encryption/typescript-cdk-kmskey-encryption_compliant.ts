// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-kmskey-encryption@v1.0 defects=0}
import { BuildSpec, Project } from "aws-cdk-lib/aws-codebuild";
import * as cdk from "@aws-cdk/core";
import { Stack } from "aws-cdk-lib/core";
import { Key } from "aws-cdk-lib/aws-kms";

  
export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

            // Compliant: The Project instantiation sets KMS key encryption configuration.
            new Project(Stack, "rBuildProject", {
                                buildSpec: BuildSpec.fromObjectToYaml(
                                    {
                                      version: 0.2,
                                      phases: {
                                          build: { commands: ['echo "foo"'] }
                                      }
                                    }),
                                encryptionKey: new Key(Stack, "rBuildKey")

            });
    }
}
// {/fact}
