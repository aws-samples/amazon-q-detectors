# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-vpc-flow-logs-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_ec2 import FlowLog, FlowLogResourceType, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        compliantVpc=Vpc(self, 'rVpc1')
        # Compliant: The FlowLog instantiation sets `resource_type` to `compliantVpc`.
        FlowLog(self, 'rFlowFlog1', 
            resource_type=FlowLogResourceType.from_vpc(compliantVpc)
        )
# {/fact}
