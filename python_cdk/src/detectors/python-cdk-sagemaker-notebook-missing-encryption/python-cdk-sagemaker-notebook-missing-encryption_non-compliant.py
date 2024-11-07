# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sagemaker-notebook-missing-encryption@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_iam import Role, ServicePrincipal
from aws_cdk.aws_sagemaker import CfnNotebookInstance

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)
    # Noncompliant: The CfnNotebookInstance instantiation does not set the `kms_key_id` property, potentially leaving data unencrypted.
    CfnNotebookInstance(self, "rNotebook",
        instance_type="ml.t3.xlarge",
        role_arn=Role(self, "rNotebookRole", 
            assumed_by=ServicePrincipal("sagemaker.amazonaws.com")
        ).role_arn
    )
    # {/fact}
