# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-bucket-enforce-ssl@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import (
    aws_s3 as s3
)

class CdkStarterStack(cdk.Stack):
	def __init__(self, scope: cdk.App, id: str):
		super(scope, id)
		
		# Noncompliant: The S3 Bucket instantiation does not set `enforce_ssl` to `True`.
		badBucket = s3.Bucket(self, "s3-bucket-bad", enforce_ssl=False)
# {/fact}
