# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-encrypted-at-rest@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_elasticsearch import CfnDomain as LegacyCfnDomain

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)

      # Noncompliant: The LegacyCfnDomain instantiation does not set the `encryption_at_rest_options` property, potentially leaving data unencrypted at rest.
      LegacyCfnDomain(self, 'Domain')
      # {/fact}
