# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-athena-incomplete-encryption@v1.0 defects=1}
from aws_cdk.aws_athena import CfnWorkGroup
from aws_cdk import Stack
import aws_cdk

class AthenaIncompleteEncryption:    
    def __init__(self):

        # Noncompliant: The CfnWorkGroup instantiation does not set the `work_group_configuration` property, potentially leaving results unencrypted.
        CfnWorkGroup(Stack, 'rWorkgroup', name='foo')
# {/fact}