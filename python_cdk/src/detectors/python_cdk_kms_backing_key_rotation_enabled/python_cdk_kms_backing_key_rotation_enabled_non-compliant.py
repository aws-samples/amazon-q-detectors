# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-kms-backing-key-rotation-enabled@v1.0 defects=1}
from aws_cdk.aws_kms import Key, KeySpec 
import aws_cdk as cdk
from aws_cdk import Stack

class CdkStarterStack(cdk.Stack):
        def __init__(self, scope: cdk.App, id: str):
                super(scope, id)        
                # Noncompliant: `enable_key_rotation` is not set.
                Key(Stack, 'rSymmetricKey')
                #{/fact}
                