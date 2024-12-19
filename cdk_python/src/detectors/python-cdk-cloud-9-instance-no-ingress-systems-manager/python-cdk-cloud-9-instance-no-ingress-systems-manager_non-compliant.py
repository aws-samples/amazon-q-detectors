# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-cloud-9-instance-no-ingress-systems-manager@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_cloud9 import CfnEnvironmentEC2
from aws_cdk.aws_ec2 import InstanceType, InstanceClass, InstanceSize

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

	    # Noncompliant: Lacks `CONNECT_SSM`, exposing the instance to less secure connection methods.
        CfnEnvironmentEC2(Stack, 'rC9Env', instance_type= InstanceType.of( InstanceClass.T2, InstanceSize.MICRO ))
# {/fact}
