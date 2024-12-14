# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-usage-of-origin-access-identity-for-cloudfront-distribution@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution, BehaviorOptions
from aws_cdk.aws_cloudfront_origins import S3Origin
from aws_cdk.aws_s3 import Bucket

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Uses an S3 origin, ensuring proper integration with S3 for content delivery.
        Distribution(self, "distribution",
            default_behavior=BehaviorOptions(
                origin=S3Origin(Bucket(self, "origin"))
            )
        )
# {/fact}
