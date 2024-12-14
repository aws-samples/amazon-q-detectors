# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-allowlisted-ips@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
    PolicyDocument,
    PolicyStatement,
    Effect,
    AnyPrincipal
)
from aws_cdk.aws_elasticsearch import (
    Domain as LegacyDomain, 
    ElasticsearchVersion
)

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
    
        # Noncompliant: Does not include an `IpAddress` condition, allowing broader access and potentially exposing the domain to unauthorized access.
        LegacyDomain(self, "Domain",
            elasticsearch_version=ElasticsearchVersion.V7_10.version,
            access_policies=PolicyDocument(
                statements=[
                    PolicyStatement(
                        effect=Effect.ALLOW,
                        principals=[AnyPrincipal()],
                        resources=["*"]
                    )
                ]
            ).to_json()
        )
# {/fact}
