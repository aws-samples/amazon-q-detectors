# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigateway-missing-cognito-auth@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_apigateway import RestApi, AuthorizationType

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: API Gateway method is added with Cognito authentication.
        RestApi(self, 'rRest').root.add_method('ANY',  
            authorization_type=AuthorizationType.COGNITO
        )
# {/fact}
