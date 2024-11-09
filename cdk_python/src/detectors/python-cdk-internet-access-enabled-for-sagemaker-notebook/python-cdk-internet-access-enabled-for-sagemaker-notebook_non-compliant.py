# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-internet-access-enabled-for-sagemaker-notebook@v1.0 defects=1}
from aws_cdk import aws_sagemaker as sagemaker
import aws_cdk as cdk

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: `direct_internet_access` is set to default.
        sagemaker.CfnNotebookInstance(self, "rNotebook",
            instance_type="ml.t3.xlarge",
            role_arn=iam.Role(
                self, "rNotebookRole",
                assumed_by=iam.ServicePrincipal("sagemaker.amazonaws.com")
            ).role_arn
        )
        #{/fact}
