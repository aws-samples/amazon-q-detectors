# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ec-2-security-group-description@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ec2 import SecurityGroup,Vpc
from aws_cdk import aws_ec2 as ec2


class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: The SecurityGroup instantiation includes an empty string as the description.
        SecurityGroup(Stack, 'rSg', 
            vpc= Vpc(Stack, 'rVpc'),
            description= ' ',
        )
# {/fact}