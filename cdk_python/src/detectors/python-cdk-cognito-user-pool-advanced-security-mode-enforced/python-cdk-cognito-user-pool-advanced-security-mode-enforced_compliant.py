# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-cognito-user-pool-advanced-security-mode-enforced@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_cognito import CfnUserPool

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: `advanced_security_mode` set to ENFORCED.
        CfnUserPool(Stack, 'rUserPool', user_pool_add_ons=CfnUserPool.UserPoolAddOnsProperty( advanced_security_mode="ENFORCED"))
# {/fact}
