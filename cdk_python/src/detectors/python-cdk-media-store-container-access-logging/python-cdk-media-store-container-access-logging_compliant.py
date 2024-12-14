# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-media-store-container-access-logging@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_mediastore import CfnContainer

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables access logging for monitoring and security.
        CfnContainer(self, 'rMsContainer', container_name='foo', access_logging_enabled=True)
# {/fact}
