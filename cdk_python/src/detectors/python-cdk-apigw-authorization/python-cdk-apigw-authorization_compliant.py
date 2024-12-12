# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigw-authorization@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_apigateway import RestApi, AuthorizationType

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: RestApi instantiation sets the `authorization_type` to CUSTOM, enabling authorization.
        RestApi(Stack, 'rRestApi', authorization_type=AuthorizationType.CUSTOM).root.add_method('ANY')
# {/fact}
