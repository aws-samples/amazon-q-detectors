# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ecr-open-access@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_ecr import Repository
from aws_cdk.aws_iam import PolicyStatement
from aws_cdk.aws_iam import Effect
from aws_cdk.aws_iam import AccountPrincipal
from aws_cdk.aws_iam import AccountRootPrincipal
from aws_cdk import Stack


class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 

        repo = Repository(Stack, 'rRepo')
        # Noncompliant: `*` principals in an ECR Repository is used.
        repo.add_to_resource_policy(PolicyStatement(effect=Effect.ALLOW, actions=['*'], principals=[AccountPrincipal('*'), AccountRootPrincipal()]))
# {/fact}
