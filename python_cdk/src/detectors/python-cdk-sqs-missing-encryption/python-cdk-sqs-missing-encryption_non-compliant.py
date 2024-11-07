# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sqs-missing-encryption@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import aws_sqs as sqs


class Stack(cdk.Stack):

    def missing_encryption_noncompliant(self):
        # Noncompliant: The Queue instantiation does not set the encryption property, leaving the queue unencrypted.
        unencrypted_queue = sqs.Queue(self, 'unencrypted_queue')
# {/fact}
