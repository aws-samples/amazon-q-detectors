// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-elastic-beanstalk-managed-updates-enabled@v1.0 defects=0}
import { CfnEnvironment } from 'aws-cdk-lib/aws-elasticbeanstalk';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Specifies `UpdateLevel: minor`, ensuring only non-disruptive updates are applied to the environment.
    new CfnEnvironment(Stack, 'rBeanstalk', {
      applicationName: 'foo',
      optionSettings: [
        {
          namespace: 'aws:elasticbeanstalk:managedactions',
          optionName: 'ManagedActionsEnabled'
        },
        {
          namespace: 'aws:elasticbeanstalk:managedactions',
          optionName: 'PreferredStartTime',
          value: 'Tue:09:00'
        },
        {
          namespace: 'aws:elasticbeanstalk:managedactions:platformupdate',
          optionName: 'UpdateLevel',
          value: 'minor'
        }
      ]
    });
  }
}
// {/fact}
