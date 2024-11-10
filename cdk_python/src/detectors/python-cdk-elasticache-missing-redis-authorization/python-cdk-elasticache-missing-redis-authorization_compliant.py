# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-elasticache-missing-redis-authorization@v1.0 defects=0}
from aws_cdk import cdk
from aws_cdk.aws_elasticache import CfnReplicationGroup
from aws_cdk import aws_elasticache as elasticache

class CdkStarterStack(core.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        # Compliant: `transit_encryption_enabled` is enabled.
        CfnReplicationGroup(self, "rRedisGroup",
            cache_node_type="cache.t3.micro",
            replication_group_description="lorem ipsum dolor sit amet",
            cache_subnet_group_name="lorem",
            transit_encryption_enabled=True,
            auth_token="secret",  
            port=42
        )
        # {/fact}

     