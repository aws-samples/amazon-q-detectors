# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ec-2-security-group-description@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ec2 import SecurityGroup,Vpc


class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Description set for the SecurityGroup.
        SecurityGroup(Stack, 'rSg', 
            vpc= Vpc(Stack, 'rVpc'),
            description= 'lorem ipsum dolor sit amet',
        )
# {/fact}