# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-dax-missing-encryption@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_dax import CfnCluster

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: The CfnCluster instantiation does not set `sse_specification` property.
        CfnCluster(Stack, 'rDax', iam_role_arn='SOMEARN', node_type='t3.small', replication_factor=3)
# {/fact}
