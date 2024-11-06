# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-s3-server-access-logs-disabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_s3 import Bucket

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: `server_access_logs_bucket` is set.
    Bucket(self, "LogsBucket", bucket_name="bar")
    Bucket(self, "Bucket", 
        server_access_logs_bucket=Bucket.from_bucket_name(
            self, "LogsBucketFromName", "bar"
        )
    )
    # {/fact}
