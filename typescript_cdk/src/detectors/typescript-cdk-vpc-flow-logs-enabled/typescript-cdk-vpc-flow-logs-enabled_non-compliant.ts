// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-vpc-flow-logs-enabled@v1.0 defects=1}
import {
    FlowLog,
    Vpc,
} from 'aws-cdk-lib/aws-ec2';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
  
    new Vpc(Stack, 'rVpc');
    // Noncompliant: `resourceType` is not set for FlowLog.
    new FlowLog(Stack, 'rFlowLog');
   
  }
}
// {/fact}