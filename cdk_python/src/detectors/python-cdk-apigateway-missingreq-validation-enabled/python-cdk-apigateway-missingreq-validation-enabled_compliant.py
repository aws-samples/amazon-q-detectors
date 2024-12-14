# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigateway-missingreq-validation-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_apigateway import RestApi

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables validation for both request body and parameters, improving security.
        compliantRestApi=RestApi(self, 'RestApi')
        compliantRestApi.add_request_validator('RequestValidator', 
            validate_request_body=True,
            validate_request_parameters=True
        )
        compliantRestApi.root.add_method('ANY')
# {/fact}
