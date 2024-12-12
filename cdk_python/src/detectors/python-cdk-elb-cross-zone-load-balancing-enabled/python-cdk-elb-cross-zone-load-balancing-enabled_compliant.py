# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-elb-cross-zone-load-balancing-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_elasticloadbalancing import LoadBalancer

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables cross-zone load balancing for better fault tolerance.
        LoadBalancer( self, 'rELB', cross_zone=True) 
# {/fact}
