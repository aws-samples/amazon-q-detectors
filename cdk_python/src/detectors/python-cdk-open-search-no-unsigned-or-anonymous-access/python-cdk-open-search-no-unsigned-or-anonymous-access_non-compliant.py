# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-open-search-no-unsigned-or-anonymous-access@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
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
        
        # Noncompliant: Uses `AnyPrincipal()` with no access restrictions, potentially allowing unrestricted access to the Elasticsearch domain.
        LegacyDomain(self, "Domain",
            version=ElasticsearchVersion.V7_10,
            access_policies=[
                PolicyStatement(
                    effect=Effect.ALLOW,
                    principals=[AnyPrincipal()],
                    resources=["*"]
                )
            ]
        )
# {/fact}
