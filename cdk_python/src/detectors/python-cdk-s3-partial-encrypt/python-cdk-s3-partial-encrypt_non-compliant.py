# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-s3-partial-encrypt@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import (
    aws_s3 as s3
)

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Lacks encryption, leaving data unprotected.
        badBucket = s3.Bucket(self, 's3-bucket-bad')
# {/fact}
        