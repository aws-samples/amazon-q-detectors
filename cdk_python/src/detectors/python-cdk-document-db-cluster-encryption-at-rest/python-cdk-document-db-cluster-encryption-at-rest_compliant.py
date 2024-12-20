# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-document-db-cluster-encryption-at-rest@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_ec2 import InstanceType,InstanceClass,InstanceSize,Vpc
from aws_cdk.aws_docdb import DatabaseCluster, core

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        vpc = Vpc(self, "MyVpc")

        # Compliant: Enables storage encryption, ensuring data at rest is secure.
        DatabaseCluster(self, 'rDatabaseCluster', instance_type= InstanceType.of(InstanceClass.MEMORY5, InstanceSize.LARGE), vpc = vpc, master_user= "foo", master_user_password=core.SecretValue.secrets_manager("bar"), storage_encrypted = True)
# {/fact}
