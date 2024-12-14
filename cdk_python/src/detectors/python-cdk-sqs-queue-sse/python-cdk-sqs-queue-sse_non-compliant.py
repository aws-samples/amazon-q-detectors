# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sqs-queue-sse@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_sqs import Queue, QueueEncryption

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: SQS Queue has server-side encryption disabled.
        Queue(self, 'rQueue', encryption=QueueEncryption.UNENCRYPTED )
# {/fact}
