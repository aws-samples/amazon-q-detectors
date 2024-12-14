# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-zone-awareness@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_opensearchservice import EngineVersion
from aws_cdk import aws_elasticsearch as LegacyDomain

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)

      # Noncompliant: Does not enable `zone_awareness`, risking lower availability and resilience.
      LegacyDomain.Domain(self, 'Domain', version=EngineVersion.OPENSEARCH_1_0)
# {/fact}
