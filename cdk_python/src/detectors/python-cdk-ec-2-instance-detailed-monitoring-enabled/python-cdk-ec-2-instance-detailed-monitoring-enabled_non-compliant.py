# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ec-2-instance-detailed-monitoring-enabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ec2 import Instance, InstanceClass, InstanceType, MachineImage, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Does not enable detailed monitoring, limiting available metrics.
        Instance(Stack, 'rInstance', 
            vpc=Vpc(Stack, 'rVpc'),
            instance_type=InstanceType.of(InstanceClass.T3),
            machine_image=MachineImage.latest_amazon_linux2()
        )
# {/fact}
