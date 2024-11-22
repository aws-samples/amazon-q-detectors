// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-step-function-state-machine-xray@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import {
  StateMachine,
  Wait,
  WaitTime
} from 'aws-cdk-lib/aws-stepfunctions';
import { Duration, Stack } from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Disables tracing, reducing visibility into the state machine's execution.
    new StateMachine(Stack, 'rStateMachine', {
      definition: new Wait(Stack, 'rWait30', {
        time: WaitTime.duration(Duration.seconds(30)),
      })
    });
  }
}
// {/fact}
