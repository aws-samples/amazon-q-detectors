# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-codebuild-project-has-public-access@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Project

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

    def non_compliant(self):
        # Noncompliant: Project instantiation sets `badge` to `True`, making private resources publicly accessible.
        publicProject1Direct = Project(self, 'publicProject', badge=True)
# {/fact}
