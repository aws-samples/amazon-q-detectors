# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-kmskey-encryption@v1.0 defects=0}
import aws_cdk
from aws_cdk.aws_codebuild import Project
from aws_cdk.aws_codebuild import BuildSpec
from aws_cdk import Stack
from aws_cdk.aws_kms import Key

class KMSKeyEncryption:
  def __init__(self):
    # Compliant: KMS key specified for encryption.
    Project(Stack, "rBuildProject", build_spec=BuildSpec.from_object_to_yaml({
        "version": 0.2,
        "phases": {
          "build": {
            "commands": ['echo "foo"'],
          },
        },
      }),
      encryption_key=Key(Stack, "rBuildKey"))
    # {/fact}
