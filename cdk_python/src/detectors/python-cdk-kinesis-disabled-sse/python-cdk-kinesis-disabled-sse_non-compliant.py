# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-kinesis-disabled-sse@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk_lib.aws_kinesis import StreamEncryption, Stream

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
          
        # Noncompliant: The Stream sets `encryption` to UNENCRYPTED.
        Stream(Stack, 'rKds',encryption=StreamEncryption.UNENCRYPTED)
# {/fact}