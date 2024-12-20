# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-neptune-cluster-encryption-at-rest@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_neptune import CfnDBCluster

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables storage encryption for data security.
        CfnDBCluster(self, 'rDatabaseCluster', storage_encrypted=True)
# {/fact}
