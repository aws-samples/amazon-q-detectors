# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-step-function-state-machine-xray@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_stepfunctions import StateMachine, LogLevel, LogOptions 
import aws_cdk.aws_stepfunctions as stepfunctions

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        start_state = stepfunctions.Pass(self, "StartState")
        # Compliant: Enables tracing for monitoring and debugging purposes.
        StateMachine(self, 'rStateMachine', definition=start_state,tracing_enabled=True, logs=LogOptions(destination="LOG_GROUP", level=LogLevel.ALL))
# {/fact}
