# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-s3-partial-encrypt@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import (
    aws_s3 as s3
)

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables encryption for data security.
        goodBucket = s3.Bucket(self, 's3-bucket', encryption=s3.BucketEncryption.S3_MANAGED)
# {/fact}
