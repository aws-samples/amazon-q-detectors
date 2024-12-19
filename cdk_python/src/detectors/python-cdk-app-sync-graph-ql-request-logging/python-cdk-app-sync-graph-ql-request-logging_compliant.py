# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-app-sync-graph-ql-request-logging@v1.0 defects=0}
from aws_cdk.aws_appsync import CfnGraphQLApi,LogConfigProperty 
import aws_cdk as cdk
from aws_cdk import Stack

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)      
    
        # Compliant: Configures logging with CloudWatch for monitoring API access and invalid requests.
        CfnGraphQLApi(Stack, 'rGraphqlApi', 
            authentication_type= 'AMAZON_COGNITO_USER_POOL',
            name= 'foo',
            log_config=LogConfigProperty(cloud_watch_logs_role_arn= 'foo')
        )
# {/fact}
