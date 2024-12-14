# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-neptune-cluster-backup-retention-period@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_neptune import CfnDBCluster

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Database cluster configured with 40-day retention period exceeds the maximum allowed limit of 35 days for automated backups.
        CfnDBCluster(self, 'rDatabaseCluster',
            backup_retention_period= 40
        )
# {/fact}
