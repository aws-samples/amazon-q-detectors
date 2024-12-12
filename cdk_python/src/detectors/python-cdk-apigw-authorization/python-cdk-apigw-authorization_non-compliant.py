# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigw-authorization@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_apigateway import RestApi

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

	    # Noncompliant: RestApi instantiation does not set the `authorization_type`, disabling authorization.
        RestApi(Stack, 'rRestApi').root.add_method('ANY')
# {/fact}
