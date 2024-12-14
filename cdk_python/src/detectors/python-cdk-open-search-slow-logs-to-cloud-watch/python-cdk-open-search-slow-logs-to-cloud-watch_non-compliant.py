# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-slow-logs-to-cloud-watch@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_elasticsearch import Domain as LegacyDomain
from aws_cdk.aws_elasticsearch import ElasticsearchVersion

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)   

        # Noncompliant: Disables logging, reducing visibility.
        LegacyDomain(self, 'Domain', 
            version=ElasticsearchVersion.V7_10
        )
# {/fact}
