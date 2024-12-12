# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-missing-storage-encryption@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_ec2 import Vpc
from aws_cdk.aws_rds import DatabaseInstance
from aws_cdk.aws_rds import DatabaseInstanceEngine
from aws_cdk.aws_rds import PostgresEngineVersion
from aws_cdk import Stack

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        
        # Compliant: Enables storage encryption for data security.
        vpc = Vpc(Stack, 'rVpc')
        DatabaseInstance(Stack, 'rDbInstance', engine=DatabaseInstanceEngine.postgres(
                version=PostgresEngineVersion.VER_13_2,
            ),
            vpc=vpc,
            storage_encrypted=True,
            port=40,
            multi_az=True,
            deletion_protection=True
        )
# {/fact}
