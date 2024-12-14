# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-allows-rds-db-security-group-for-inbound-access@v1.0 defects=1}
from aws_cdk import cdk
from aws_cdk.aws_rds import CfnDBSecurityGroupIngress

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Allows access from all IPs.
        CfnDBSecurityGroupIngress(self, "rIngress",
            db_security_group_name="foo",
            cidrip="0.0.0.0/0"
        )
# {/fact}
