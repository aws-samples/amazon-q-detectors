# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-document-db-cluster-log-exports@v1.0 defects=1}
from aws_cdk.aws_docdb import CfnDBCluster
from aws_cdk import SecretValue, Stack 
import aws_cdk as cdk

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)     

      # Noncompliant: The DatabaseCluster instantiation does not set `enable_cloudwatch_logs_exports`.
      CfnDBCluster(Stack, 'rDatabaseCluster', 
        master_username=SecretValue.secrets_manager('foo'),
        master_user_password=SecretValue.secrets_manager('bar'),
        enable_cloudwatch_logs_exports=['authenticate', 'dropCollection']
      )
# {/fact}      
