# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-cloud-front-distribution-no-outdated-ssl@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution,OriginSslPolicy  
from aws_cdk.aws_cloudfront_origins import HttpOrigin

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 
 
        # Compliant: Uses TLS 1.2, ensuring stronger encryption and security.
        Distribution(self, 'rDistribution', 
            default_behavior = {
                'origin' : HttpOrigin('foo.bar.com', 
                originSslProtocols = [
                    OriginSslPolicy.TLS_V1_2
                ]
               )
            },
            enable_logging = True
        )
# {/fact}
