# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sns-topic-ssl-publish-only@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
  AnyPrincipal,
  Effect,
  PolicyDocument, 
  PolicyStatement
)
from aws_cdk.aws_sns import CfnTopicPolicy


class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Policy uses `Effect.ALLOW` with `aws:SecureTransport: false` which permits non-SSL connections.
        CfnTopicPolicy(self, "rTopicPolicy",
            topics=["foo"],
            policy_document=PolicyDocument(
                statements=[
                    PolicyStatement(
                        actions=["sqs:*"],
                        effect=Effect.ALLOW,
                        principals=[AnyPrincipal()],
                        conditions={"Bool": {"aws:SecureTransport": False}},
                        resources=["foo"]
                    )
                ]
            ).to_json()
        )
# {/fact}
