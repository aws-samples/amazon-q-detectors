# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-sns-topic-ssl-publish-only@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_iam import (
  Effect,
  PolicyDocument, 
  PolicyStatement,
  StarPrincipal
)
from aws_cdk.aws_sns import CfnTopicPolicy

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Policy uses `Effect.DENY` with `aws:SecureTransport: False` to explicitly block non-SSL connections.
        CfnTopicPolicy(self, 'rTopicPolicy', 
                topics=['foo'],
                policy_document=PolicyDocument(
                statements=[
                    PolicyStatement(
                    actions=['sns:Publish'],
                    effect=Effect.DENY,
                    principals=[StarPrincipal()],
                    conditions={ "Bool": { 'aws:SecureTransport': False } },
                    resources=['foo']
                    )
                ]
            ).to_json()
        )
# {/fact}
