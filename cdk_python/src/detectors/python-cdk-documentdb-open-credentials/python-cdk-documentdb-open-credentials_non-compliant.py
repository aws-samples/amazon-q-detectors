# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-documentdb-open-credentials@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_docdb import DatabaseCluster, Login
from aws_cdk.aws_ec2 import  InstanceType, InstanceClass, InstanceSize, Vpc
from aws_cdk import SecretValue

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: `DocumentDB` cluster is created with `username` in plain text.
        DatabaseCluster(self, "DatabaseCluster",
            instance_type=InstanceType.of(InstanceClass.R5, InstanceSize.LARGE), 
            vpc=Vpc(self, "Vpc"),
            master_user=Login(username="foo", password=SecretValue.secrets_manager("bar"))
        )
# {/fact}
