# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-zone-awareness@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_opensearchservice import EngineVersion, ZoneAwarenessConfig, CapacityConfig
from aws_cdk import aws_elasticsearch as LegacyDomain

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)

      # Compliant: Enables `zone_awareness` for high availability and fault tolerance.
      LegacyDomain.Domain(self, 'Domain', version=EngineVersion.OPENSEARCH_1_3, capacity=CapacityConfig(master_nodes=2), zone_awareness=ZoneAwarenessConfig(enabled=True))
# {/fact}
