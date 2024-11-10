# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-elasticache-cluster-usage-of-default-port@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_elasticache import CfnCacheCluster

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: ElastiCache cluster uses the default endpoint port.
    CfnCacheCluster(
        self, "rAec",
        cache_node_type="cache.t3.micro",
        engine="memcached",
        num_cache_nodes=42,
        port=42  
    )
    # {/fact}
