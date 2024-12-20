# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigateway-missing-cognito-auth@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_apigateway import RestApi

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: API Gateway method is added without any authentication.
        RestApi(self, 'RestApi').root.add_method('ANY')
# {/fact}
