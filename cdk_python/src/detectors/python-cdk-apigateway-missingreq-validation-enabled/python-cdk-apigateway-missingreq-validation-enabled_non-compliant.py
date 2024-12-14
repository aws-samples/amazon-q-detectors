# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-apigateway-missingreq-validation-enabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import aws_apigateway as apigateway

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Disables validation, allowing potentially invalid or malicious requests.
        compliantRestApi=apigateway.RestApi(self, 'RestApi')
        compliantRestApi.add_request_validator('RequestValidator', 
            validate_request_body=False,
            validate_request_parameters=False,
        )
        compliantRestApi.root.add_method('ANY')
# {/fact}