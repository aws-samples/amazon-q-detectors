# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-cloud-front-distribution-no-outdated-ssl@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution, OriginSslPolicy  
from aws_cdk.aws_cloudfront_origins import HttpOrigin
 
class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 

        # Noncompliant: Uses TLS 1.0 and 1.1, which are outdated and less secure.
        Distribution(self, 'rDistribution', 
            default_behavior= {
                'origin' : HttpOrigin('foo.bar.com', 
                 originSslProtocols= [
                     OriginSslPolicy.TLS_V1,
                     OriginSslPolicy.TLS_V1_1
                 ]
                )
            },
            enable_logging=True
        )
# {/fact}
