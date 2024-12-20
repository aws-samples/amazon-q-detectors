# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-slow-logs-to-cloud-watch@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_elasticsearch import Domain as LegacyDomain
from aws_cdk.aws_elasticsearch import ElasticsearchVersion, LoggingOptions

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)   

        # Compliant: Enables logging for better monitoring.
        LegacyDomain(self, 'Domain', 
            version=ElasticsearchVersion.V7_10,
            logging=LoggingOptions(slow_index_log_group=True, slow_search_log_group=True)
        )
# {/fact}
