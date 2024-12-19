# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-elb-logging-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_ec2 import Vpc
from aws_cdk.aws_elasticloadbalancing import LoadBalancer

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enabled access logging by setting `access_logging_policy` to `True` for Classic Load Balancers.
        LoadBalancer(self, 'rELB', 
            vpc =  Vpc(self, 'rVPC3'),
            access_logging_policy = LoadBalancer.AccessLoggingPolicyProperty(
                s3_bucket_name = 'foo',
                enabled =  True
            )
        )
# {/fact}
