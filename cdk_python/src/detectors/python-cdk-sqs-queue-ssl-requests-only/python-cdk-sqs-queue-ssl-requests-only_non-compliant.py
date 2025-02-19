# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sqs-queue-ssl-requests-only@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
    AnyPrincipal,
    Effect,
    PolicyDocument, 
    PolicyStatement
)
from aws_cdk.aws_sqs import CfnQueuePolicy, Queue 

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Policy uses `Effect.ALLOW` with `aws:SecureTransport: False` which permits non-SSL requests.
        queue=Queue(self, "rQueue", queue_name="foo")
        CfnQueuePolicy(self, "rQueuePolicy",
            queues=[queue.queue_name],
            policy_document=PolicyDocument(
                statements=[
                    PolicyStatement(
                        actions=["sqs:*"],
                        effect=Effect.ALLOW,
                        principals=[AnyPrincipal()],
                        conditions={"Bool": {"aws:SecureTransport": False}},
                        resources=[queue.queue_arn]
                    )
                ]
            ).to_json()
        )
# {/fact}
