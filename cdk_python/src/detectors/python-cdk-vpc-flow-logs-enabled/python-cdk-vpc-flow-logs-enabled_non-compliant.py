# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-vpc-flow-logs-enabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_ec2 import FlowLog, FlowLogResourceType, Vpc

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: `resourceType` is not set for `FlowLog`.
        vpc = Vpc(self, 'rVpc')
        FlowLog(self, 'rFlowLog', 
            resource_type =FlowLogResourceType.from_vpc()
        )
# {/fact}
