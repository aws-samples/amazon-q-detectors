# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-redshift-missing-encryption@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_redshift import CfnCluster
from aws_cdk import Stack

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Encryption at rest is enabled.
        CfnCluster(Stack, 'rRedshiftCluster', 
            masterUsername='use_a_secret_here',
            masterUserPassword='use_a_secret_here',
            clusterType='single-node',
            dbName='bar',
            nodeType='ds2.xlarge',
            encrypted=True
        )
# {/fact}
