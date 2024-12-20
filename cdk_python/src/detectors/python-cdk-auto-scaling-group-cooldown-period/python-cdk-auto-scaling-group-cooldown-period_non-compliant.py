# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-auto-scaling-group-cooldown-period@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Vpc, Duration
from aws_cdk.aws_autoscaling import AutoScalingGroup
from aws_cdk.aws_ec2 import InstanceClass, InstanceType, MachineImage, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: No cooldown, leading to potential rapid, uncoordinated scaling.
        AutoScalingGroup(self, 'rAsg',
            vpc=Vpc(self, 'rVpc'),
            instance_type=InstanceType(InstanceClass.T3),
            machine_image=MachineImage.latestAmazonLinux(),
            cooldown=Duration.minutes(3)
        )
# {/fact}
