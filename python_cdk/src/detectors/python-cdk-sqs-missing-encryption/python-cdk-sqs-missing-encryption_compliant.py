# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sqs-missing-encryption@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import aws_sqs as sqs


class Stack(cdk.Stack):

    def missing_encryption_compliant(self):
        # Compliant: Encryption present.
        encrypted_queue = sqs.Queue(self, 'encrypted_queue',
                                    encryption=sqs.QueueEncryption.KMS_MANAGED)
# {/fact}
