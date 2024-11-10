# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-instance-backup-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_rds import CfnDBInstance
class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 
        # Compliant: `backup_retention_period` is set to default.
        CfnDBInstance(self, 'rDbInstance', 
            db_instance_class= 'db.t3.micro',
        )
        #{/fact}
