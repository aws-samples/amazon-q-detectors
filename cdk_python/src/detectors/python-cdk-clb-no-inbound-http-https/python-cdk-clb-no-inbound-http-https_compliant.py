# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-clb-no-inbound-http-https@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Vpc
from aws_cdk.aws_elasticloadbalancing import LoadBalancer, LoadBalancingProtocol

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: The `LoadBalancer` uses `SSL` on port `42`, ensuring secure communication.
        elb2=LoadBalancer(self, 'rELB', 
          vpc=Vpc(self, 'rVPC')
        )
        elb2.add_listener(
          external_port=42,
          external_protocol=LoadBalancingProtocol.ssl
        )
# {/fact}
