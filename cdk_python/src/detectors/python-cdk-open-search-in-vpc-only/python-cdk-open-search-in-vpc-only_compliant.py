# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-in-vpc-only@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_opensearchservice import CfnDomain
	 
class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: The LegacyCfnDomain instantiation sets `subnet_ids`.
        CfnDomain(self, 'Domain2', 
            vpc_options=CfnDomain.VPCOptionsProperty(
                subnet_ids=["subnetIds"]
            )
        )
# {/fact}
