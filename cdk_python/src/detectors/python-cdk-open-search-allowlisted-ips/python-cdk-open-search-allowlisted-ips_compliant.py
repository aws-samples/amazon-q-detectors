# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-allowlisted-ips@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
    AccountRootPrincipal, 
    PolicyDocument,
    PolicyStatement,
    Role,
    Effect
)
from aws_cdk.aws_elasticsearch import (
    CfnDomain as LegacyCfnDomain,
    ElasticsearchVersion
)

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
    
        # Compliant: Specifies an `IpAddress` condition for access, restricting access to a specific IP address for added security.
        LegacyCfnDomain(self, "Domain",
            elasticsearch_version=ElasticsearchVersion.V7_10.version,
            access_policies=PolicyDocument(
                statements=[
                    PolicyStatement(
                        effect=Effect.ALLOW,
                        principals=[
                            Role(self, "Role",
                                assumed_by=AccountRootPrincipal()
                            )
                        ],
                        resources=["*"],
                        conditions={
                            "IpAddress": {
                                "aws:SourceIp": ["42.42.42.42"]
                            }
                        }
                    )
                ]
            ).to_json()
        )
# {/fact}
