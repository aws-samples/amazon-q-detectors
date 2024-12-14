# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-deletion-protection-enabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_rds import DatabaseInstance, DatabaseInstanceEngine, PostgresEngineVersion
from aws_cdk.aws_ec2 import Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: `deletion_protection` in `DatabaseCluster` is disabled.
        DatabaseInstance(
            self, "DbInstance",
            engine=DatabaseInstanceEngine.POSTGRES,
            engine_version=PostgresEngineVersion.VER_13_2,
            vpc=Vpc(self, "Vpc"),
            deletion_protection=False
        )
# {/fact}
