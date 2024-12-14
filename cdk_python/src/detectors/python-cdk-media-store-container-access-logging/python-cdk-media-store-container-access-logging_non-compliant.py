# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-media-store-container-access-logging@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_mediastore import CfnContainer

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Access logging is disabled, missing security and auditability.
        CfnContainer(self, 'rMsContainer', container_name='foo')
# {/fact}
