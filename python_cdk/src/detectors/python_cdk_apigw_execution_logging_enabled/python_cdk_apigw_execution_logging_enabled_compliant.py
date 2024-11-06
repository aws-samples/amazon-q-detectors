# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigw-execution-logging-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_apigateway import RestApi, MethodLoggingLevel, StageOptions

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: The RestApi instantiation has the `logging_level` property set, enabling logging for the API.
        RestApi(Stack, 'rRestApi', deploy_options= StageOptions( logging_level= MethodLoggingLevel.ERROR)).root.add_method('ANY')
# {/fact}