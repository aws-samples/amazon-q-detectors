# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-efs-encrypted@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_efs import FileSystem, ec2

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: EFS is created without encryption, exposing data to potential security risks.
        FileSystem(Stack, 'rEFS', vpc=ec2.Vpc(self, "rVpc"), encrypted=False)
# {/fact}
