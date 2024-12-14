# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-usage-of-origin-access-identity-for-cloudfront-distribution@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution, BehaviorOptions
from aws_cdk.aws_cloudfront_origins import  HttpOrigin

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Uses an HTTP origin, which may cause security and performance issues.
        Distribution(self, "distribution",
            default_behavior=BehaviorOptions(
                origin=HttpOrigin("foo.s3-website.amazonaws.com")
            )
        )
# {/fact}
