# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-publicly-accessible-redshift-cluster@v1.0 defects=0}
from aws_cdk.aws_redshift import CfnCluster
from aws_cdk import aws_redshift as redshift
import aws_cdk as cdk

class CdkStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: `publicly_accessible` is set to default.
        CfnCluster(self, "rRedshiftCluster",
            master_username="awsuser",
            master_user_password="use_a_secret_here",
            cluster_type="single-node",
            db_name="bar", 
            node_type="ds2.xlarge"  
        )
        # {/fact}

      