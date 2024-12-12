# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ec2-instance-termination-protection@v1.0 defects=0}
from aws_cdk.aws_ec2 import Instance, InstanceType, MachineImage, InstanceClass, Vpc 
import aws_cdk as cdk


class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 

        # Compliant: Disables API termination, preventing accidental instance termination.
        instance = Instance(self, 'rInstance', 
            vpc= Vpc(self, 'rVpc'),
            instance_type =  InstanceType.of(InstanceClass.T3),
            machine_image= MachineImage.latestAmazonLinux2(),
            detailed_monitoring=True
        )
        instance.instance.disable_api_termination = True
# {/fact}
