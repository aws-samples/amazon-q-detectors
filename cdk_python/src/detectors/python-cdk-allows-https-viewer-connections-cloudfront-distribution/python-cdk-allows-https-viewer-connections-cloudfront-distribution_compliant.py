# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-allows-https-viewer-connections-cloudfront-distribution@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution, OriginSslPolicy, BehaviorOptions
from aws_cdk.aws_cloudfront_origins import HttpOrigin

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Uses the secure `TLS_V1_2` protocol for encryption.
        Distribution(
            self, "Distribution2",
            default_behavior=BehaviorOptions(
                origin=HttpOrigin(
                    "foo.bar.com", 
                    origin_ssl_protocols=[
                        OriginSslPolicy.TLS_V1_2
                    ]
                )
            )
        ) 
# {/fact}
