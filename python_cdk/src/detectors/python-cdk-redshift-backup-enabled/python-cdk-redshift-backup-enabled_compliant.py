# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-redshift-backup-enabled@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import aws_redshift as redshift 
from aws_cdk import Stack 

class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        
        # Compliant: `automated_snapshot_retention_period` is set.
        redshift.CfnCluster(Stack, 'rRedshiftCluster', 
            master_username= 'use_a_secret_here',
            master_user_password= 'use_a_secret_here',
            cluster_type= 'single-node',
            db_name= 'bar',
            node_type= 'ds2.xlarge',
            automated_snapshot_retention_period= 15,
            encrypted= True,
            port=42,
        )
        # {/fact }