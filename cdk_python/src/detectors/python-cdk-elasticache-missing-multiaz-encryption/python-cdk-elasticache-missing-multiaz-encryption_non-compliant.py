# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-elasticache-missing-multiaz-encryption@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_elasticache import CfnReplicationGroup
from aws_cdk import SecretValue

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Does not enable Multi-AZ, reducing availability and fault tolerance.
        CfnReplicationGroup(self, "rRedisGroup",
            cache_node_type="cache.t3.micro",
            engine="redis", 
            replication_group_description="lorem ipsum dolor sit amet",
            at_rest_encryption_enabled=True,
            transit_encryption_enabled=True,
            auth_token=SecretValue.secretsManager('foo').toString()
        )
# {/fact}
