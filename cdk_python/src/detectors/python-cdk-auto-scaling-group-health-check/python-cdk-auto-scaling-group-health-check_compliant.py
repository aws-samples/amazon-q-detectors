# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-auto-scaling-group-health-check@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_autoscaling import CfnAutoScalingGroup

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Uses `EC2` health check, suitable for EC2-based scaling.
        CfnAutoScalingGroup(self, 'rAsg', 
            min_size='7',
            max_size='42',
            health_check_type='EC2'
        )
# {/fact}
