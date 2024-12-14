# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-deletion-protection-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_rds import  AuroraEngineVersion, DatabaseCluster, DatabaseClusterEngine
from aws_cdk.aws_ec2 import Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: The DatabaseCluster instantiation sets `deletion_protection` to `True`.
        DatabaseCluster(
            self, "DbCluster", 
            engine=DatabaseClusterEngine.AURORA_MYSQL,
            engine_version=AuroraEngineVersion.VER_5_7_12,
            vpc=Vpc(self, "Vpc"),
            deletion_protection=True  
        )
# {/fact}
