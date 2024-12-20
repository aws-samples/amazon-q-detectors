# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sqs-queue-sse@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_sqs import Queue
from aws_cdk.aws_kms import Key 

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

	      # Compliant: SQS Queue has server-side encryption enabled.
        Queue(self, 'rQueue', encryption_master_key=Key(self, "Key") )
# {/fact}
