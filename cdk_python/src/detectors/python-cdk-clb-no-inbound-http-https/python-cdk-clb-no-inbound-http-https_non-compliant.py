# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-clb-no-inbound-http-https@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Vpc
from aws_cdk.aws_elasticloadbalancing import LoadBalancer

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: The `LoadBalancer` uses `HTTP` on port `80`, which is insecure.
        elb=LoadBalancer(self, 'rELB', 
          vpc=Vpc(self, 'rVPC')
        )
        elb.add_listener(external_port=80)
# {/fact}
