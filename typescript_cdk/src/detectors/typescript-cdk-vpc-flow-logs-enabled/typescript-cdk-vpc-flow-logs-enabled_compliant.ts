// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-vpc-flow-logs-enabled@v1.0 defects=0}
import {
    FlowLog,
    FlowLogResourceType,
    Vpc,
} from 'aws-cdk-lib/aws-ec2';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
  
    const compliantVpc = new Vpc(Stack, 'rVpc1');
    // Compliant: The FlowLog instantiation sets `resourceType` to `compliantVpc`.
    new FlowLog(Stack, 'rFlowFlog1', {
        resourceType: FlowLogResourceType.fromVpc(compliantVpc),
    });
    
  }
}
// {/fact}