# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-document-db-cluster-log-exports@v1.0 defects=0}
from aws_cdk.aws_docdb import CfnDBCluster
from aws_cdk import SecretValue, Stack 
import aws_cdk as cdk

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)     

        # Compliant: The CfnDBCluster instantiation sets `enable_cloudwatch_logs_exports`, enabling authenticate, createIndex, and dropCollection Log Exports.
        CfnDBCluster(Stack, 'rDatabaseCluster', 
            master_username=SecretValue.secrets_manager('foo'),
            master_user_password=SecretValue.secrets_manager('bar'),
            enable_cloudwatch_logs_exports=[
              'authenticate',
              'createIndex',
              'dropCollection'
            ]
        )
# {/fact}
