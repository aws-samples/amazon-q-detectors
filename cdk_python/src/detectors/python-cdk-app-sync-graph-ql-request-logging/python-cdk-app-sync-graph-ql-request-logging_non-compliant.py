# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-app-sync-graph-ql-request-logging@v1.0 defects=1}
from aws_cdk.aws_appsync import CfnGraphQLApi,LogConfigProperty 
import aws_cdk as cdk
from aws_cdk import Stack

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)      
    
        # Noncompliant: Missing request-level logging, reducing visibility into API access and usage.
        CfnGraphQLApi(Stack, 'rGraphqlApi',
            authentication_type= 'AMAZON_COGNITO_USER_POOL',
            name= 'foo'
        )
# {/fact}
