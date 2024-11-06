# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-s3-server-access-logs-disabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import aws_s3 as s3
from aws_cdk.aws_s3 import Bucket

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Noncompliant: `server_access_logs_bucket` is not set.
    Bucket(self, "Bucket") 
    # {/fact}
