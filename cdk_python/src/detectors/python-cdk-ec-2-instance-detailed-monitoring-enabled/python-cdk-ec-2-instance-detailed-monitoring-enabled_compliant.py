# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ec-2-instance-detailed-monitoring-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ec2 import Instance, InstanceClass, InstanceType, MachineImage, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables detailed monitoring, providing enhanced performance metrics.
        Instance(Stack, 'rInstance', 
            vpc=Vpc(Stack, 'rVpc'),
            instance_type=InstanceType(InstanceClass.T3),
            machine_image=MachineImage.latestAmazonLinux2(),
            detailed_monitoring=True
        )
# {/fact}
