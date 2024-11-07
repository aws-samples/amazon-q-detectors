# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-missing-node-to-node-encryption@v1.0 defects=0}
import aws_cdk
from aws_cdk.aws_elastic_search import CfnDomain as LegacyCfnDomain
from aws_cdk.aws_opensearchservice import CfnDomain
from aws_cdk import Stack

class CdkStarterStack(aws_cdk.Stack):
    def __init__(self):

        # Compliant: The LegacyCfnDomain instantiation sets the `node_to_node_encryption_options` property with NodeToNodeEncryptionOptionsProperty,enabling encryption at rest.
        LegacyCfnDomain(Stack, 'Domain',
            node_to_node_encryption_options=CfnDomain.NodeToNodeEncryptionOptionsProperty(
                enabled=True
            )
        )

# {/fact}