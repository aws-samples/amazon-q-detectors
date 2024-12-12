# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ecr-open-access@v1.0 defects=0}
from aws_cdk.aws_ecr import Repository
from aws_cdk import Stack
import aws_cdk as cdk

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 

        # Compliant: `*` principals in an ECR Repository is not used.
        Repository(Stack, 'rRepo')
# {/fact}
