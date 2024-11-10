# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-cognito-user-pool-no-unauthenticated-logins@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_cognito import CfnIdentityPool
import aws_cdk.aws_cognito as cognito

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
    # Compliant: `allow_unauthenticated_identities` is set to `False`.
    CfnIdentityPool(Stack, 'rIdentityPool', allow_unauthenticated_identities=False)
    # {/fact}
