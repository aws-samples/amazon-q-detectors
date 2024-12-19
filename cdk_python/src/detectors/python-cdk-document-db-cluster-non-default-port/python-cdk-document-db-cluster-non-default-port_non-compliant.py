# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-document-db-cluster-non-default-port@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_ec2 import InstanceType,InstanceClass,InstanceSize,Vpc
from aws_cdk.aws_docdb import DatabaseCluster, core

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        vpc = Vpc(self, "MyVpc")
        # Noncompliant: Uses the default port, increasing potential security risks.
        DatabaseCluster(self, 'rDatabaseCluster', instance_type=InstanceType.of(InstanceClass.MEMORY5, InstanceSize.LARGE), vpc=vpc, master_user="foo", master_user_password=core.SecretValue.secrets_manager("bar"))
# {/fact}
