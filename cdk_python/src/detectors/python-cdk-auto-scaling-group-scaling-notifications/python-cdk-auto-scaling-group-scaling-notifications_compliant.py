# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-auto-scaling-group-scaling-notifications@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_autoscaling import AutoScalingGroup, ScalingEvents,ScalingEvent, NotificationConfiguration
from aws_cdk.aws_sns import Topic, TopicEncryption
from aws_cdk.aws_ec2 import InstanceClass,InstanceType, MachineImage, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        negTopic=Topic(self, 'rAsgTopic', encryption=TopicEncryption.KMS)
        # Compliant: Covers notifications for events other than error events.
        AutoScalingGroup(self, 'rAsg', 
            vpc=Vpc(self, 'rVpc'),
            instance_type=InstanceType.of(InstanceClass.MEMORY5),
            machine_image=MachineImage.latestAmazonLinux(),
            notifications=[
                NotificationConfiguration(
                    scaling_events=ScalingEvents.LAUNCH_EVENTS,
                    topic=negTopic
                ),
                NotificationConfiguration(
                    scaling_events=[
                        ScalingEvent.INSTANCE_LAUNCH,           # New instance started
                        ScalingEvent.INSTANCE_LAUNCH_ERROR,     # Failed to start an instance
                        ScalingEvent.INSTANCE_TERMINATE,        # Instance terminated
                        ScalingEvent.INSTANCE_TERMINATE_ERROR,  # Failed to terminate an instance
                        ScalingEvent.TEST_NOTIFICATION,         # Test notification (can be useful for testing)
                        ScalingEvent.SCALE_IN_EVENT,            # Notify when the ASG scales in (reduces instances)
                        ScalingEvent.SCALE_OUT_EVENT            # Notify when the ASG scales out (adds instances).
                    ], 
                    topic=negTopic
                )  
            ]
        )
# {/fact}
