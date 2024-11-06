# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-athena-incomplete-encryption@v1.0 defects=0}
from aws_cdk.aws_athena import CfnWorkGroup
from aws_cdk import Stack

class AthenaIncompleteEncryption:    
    def __init__(self):
        # Compliant: `work_group_configuration` is set. 
        CfnWorkGroup(Stack, 'rWorkgroup', name='foo',
            work_group_configuration=CfnWorkGroup.WorkGroupConfigurationProperty(
                enforce_work_group_configuration=True,
                result_configuration=CfnWorkGroup.ResultConfigurationProperty(
                    encryption_configuration=CfnWorkGroup.EncryptionConfigurationProperty(
                        encryption_option='SSE_S3',
                    )
                )
            )
        )
    # {/fact}