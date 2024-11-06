# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-missing-node-to-node-encryption@v1.0 defects=1}
import aws_cdk
from aws_cdk.aws_elastic_search import CfnDomain as LegacyCfnDomain
from aws_cdk.aws_opensearchservice import CfnDomain
from aws_cdk import Stack

class CdkStarterStack(aws_cdk.Stack):
    def __init__(self):
        # Noncompliant: The LegacyCfnDomain instantiation does not set the `encryption_at_rest_options` property, potentially leaving data unencrypted at rest.
        # Noncompliant: The LegacyCfnDomain instantiation does not set the `node_to_node_encryption_options` property, potentially leaving data unencrypted at rest.

       
# {/fact}