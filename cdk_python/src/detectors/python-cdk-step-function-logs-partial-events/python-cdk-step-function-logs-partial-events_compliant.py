# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-step-function-logs-partial-events@v1.0 defects=0}
from aws_cdk import Stack
from aws_cdk.aws_stepfunctions import StateMachine
import aws_cdk as cdk


class StepFunctionLog:
    
    def __init__(self):
        super(scope, id, props)

        # Compliant: logs enabled with `LogLevel.ALL`.
        StateMachine(Stack, 'rStateMachine', logs=sfn.LogOptions(
            destination=log_group,
            level=sfn.LogLevel.ALL
        ))
        # {/fact}
