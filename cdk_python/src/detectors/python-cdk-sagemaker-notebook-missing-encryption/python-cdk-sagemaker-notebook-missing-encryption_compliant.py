# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sagemaker-notebook-missing-encryption@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_iam import Role, ServicePrincipal
from aws_cdk.aws_sagemaker import CfnNotebookInstance

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: The CfnNotebookInstance instantiation sets the `kms_key_id` property, enabling encryption with the specified KMS key.
    CfnNotebookInstance(self, "rNotebook",
        instance_type="ml.t3.xlarge",
        role_arn=Role(self, "rNotebookRole",
            assumed_by=ServicePrincipal("sagemaker.amazonaws.com")
        ).role_arn,
        kms_key_id="1234abcd-12ab-34cd-56ef-1234567890ab"
    )
    # {/fact}
