# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-multiaz-support-enabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_rds import DatabaseInstance, DatabaseInstanceEngine

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Disables Multi-AZ, reducing availability and fault tolerance.
        DatabaseInstance(self, "rDbInstance", 
            engine=DatabaseInstanceEngine.POSTGRES,
            multi_az=False,
            storage_encrypted=True,
            deletion_protection=True,
            backup_retention=cdk.Duration.days(7),
            removal_policy=cdk.RemovalPolicy.RETAIN,
            port=40
        )
# {/fact}
