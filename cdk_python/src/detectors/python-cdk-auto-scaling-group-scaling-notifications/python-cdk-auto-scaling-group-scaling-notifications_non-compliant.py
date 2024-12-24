# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-auto-scaling-group-scaling-notifications@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_autoscaling import AutoScalingGroup, ScalingEvents, NotificationConfiguration
from aws_cdk.aws_sns import Topic
from aws_cdk.aws_ec2 import InstanceClass,InstanceType, MachineImage, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Only configures error events, limiting notification coverage.
        AutoScalingGroup(self, 'rAsg', 
            vpc=Vpc(self, 'rVpc'),
            instance_type=InstanceType.of(InstanceClass.MEMORY5),
            machine_image=MachineImage.latestAmazonLinux(),
            notifications=[
                NotificationConfiguration(
                    topic=Topic(self, 'rAsgTopic'),
                    scaling_events=ScalingEvents.ERRORS
                ) 
            ]
        )
# {/fact}
