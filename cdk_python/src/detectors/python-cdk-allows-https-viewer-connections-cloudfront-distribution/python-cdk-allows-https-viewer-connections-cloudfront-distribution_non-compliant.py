# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-allows-https-viewer-connections-cloudfront-distribution@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution, BehaviorOptions, OriginSslPolicy  
from aws_cdk.aws_cloudfront_origins import HttpOrigin

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Uses insecure `TLS_V1` and `TLS_V1_1` protocols.
        Distribution(
            self, "Distribution",
            default_behavior=BehaviorOptions(
                origin=HttpOrigin(
                    "foo.bar.com",
                    origin_ssl_protocols=[
                        OriginSslPolicy.TLS_V1,
                        OriginSslPolicy.TLS_V1_1
                    ]
                )
            )
        )
# {/fact}
