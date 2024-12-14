# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-neptune-cluster-backup-retention-period@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_neptune import CfnDBCluster

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Database cluster configured with a 7-day backup retention period, meeting the minimum recommended backup retention requirements.
        CfnDBCluster(self, 'rDatabaseCluster',
            backup_retention_period= 7
        )
# {/fact}
