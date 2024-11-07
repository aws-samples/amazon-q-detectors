# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-instance-backup-enabled@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_rds import CfnDBInstance
from aws_cdk import aws_rds as rds 
class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 

        # Noncompliant: `backup_retention_period` is set to 0.
        CfnDBInstance(self, 'rDbInstance', 
            db_instance_class= 'db.t3.micro',
            backup_retention_period= 0,
        )
        #{/fact}

       