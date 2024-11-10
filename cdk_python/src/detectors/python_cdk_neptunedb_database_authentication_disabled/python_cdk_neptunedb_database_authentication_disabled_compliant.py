# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-neptunedb-database-authentication-disabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_neptune import CfnDBCluster


class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        # Compliant: The CfnDBCluster instantiation sets the `iam_auth_enabled` property to True, enabling IAM authentication for the database cluster.
        CfnDBCluster(Stack, "rDatabaseCluster", iam_auth_enabled=True)

# {/fact}