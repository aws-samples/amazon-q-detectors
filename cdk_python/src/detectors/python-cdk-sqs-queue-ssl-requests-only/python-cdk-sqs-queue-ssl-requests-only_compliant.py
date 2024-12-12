# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sqs-queue-ssl-requests-only@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
    Effect,
    PolicyDocument, 
    PolicyStatement,
    StarPrincipal
)
from aws_cdk.aws_sqs import CfnQueuePolicy

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Policy uses `Effect.DENY` with `aws:SecureTransport: False` to block non-SSL requests.
        CfnQueuePolicy(self, "rQueuePolicy",
            queues=["foo"],
            policy_document=PolicyDocument(
                statements=[
                    PolicyStatement(
                        actions=["sqs:*"],
                        effect=Effect.DENY,
                        principals=[StarPrincipal()],
                        conditions={"Bool": {"aws:SecureTransport": False}},
                        resources=["foo"]
                    )
                ]
            ).to_json()
        )
# {/fact}
