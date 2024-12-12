# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-codebuild-project-has-public-access@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Project

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

    def compliant(self):
        # Compliant: Project instantiation does not set `badge` to `True`, making private resources publicly accessible.
        privateProject2Direct = Project(self, 'privateProject2', badge=False)
# {/fact}
