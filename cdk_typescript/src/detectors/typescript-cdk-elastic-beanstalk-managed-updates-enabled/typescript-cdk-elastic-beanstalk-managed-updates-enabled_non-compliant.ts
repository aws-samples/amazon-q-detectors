// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elastic-beanstalk-managed-updates-enabled@v1.0 defects=1}
import { CfnEnvironment } from 'aws-cdk-lib/aws-elasticbeanstalk';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Does not specify `UpdateLevel`, potentially allowing disruptive updates that could affect application stability.
    new CfnEnvironment(Stack, 'rBeanstalk', {
      applicationName: 'foo'
    });
  }
}
// {/fact}
