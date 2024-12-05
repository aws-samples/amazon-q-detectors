// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-rds-multiaz-support-enabled@v1.0 defects=0}
import {
  DatabaseInstance,
  DatabaseInstanceEngine,
  PostgresEngineVersion
} from "aws-cdk-lib/aws-rds";
import { Stack } from "aws-cdk-lib";
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Enables Multi-AZ deployment for high availability and fault tolerance.
    new DatabaseInstance(Stack, "rDbInstance", {
      engine: DatabaseInstanceEngine.postgres({
        version: PostgresEngineVersion.VER_13_2,
      }),
      multiAz: true
    });
  }
}
// {/fact}
