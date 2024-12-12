# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-dax-missing-encryption@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_dax import CfnCluster
from aws_cdk import aws_dax as dax

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: The CfnCluster instantiation sets `sse_specification` property, enabling `sse_enabled` to `True`.
        CfnCluster(Stack, 'rDax', iam_role_arn="ARN", node_type='t3.small', replication_factor=7,
            sse_specification=dax.CfnCluster.SSESpecificationProperty(sse_enabled=True)
        )
# {/fact}
