# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-redshift-cluster-usage-of-default-port@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_redshift import CfnCluster

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: The `CfnCluster` instantiation does not have a custom port value, using the default port instead.
        CfnCluster(
            self, "rRedshiftCluster",
            master_username="use_a_secret_here",
            master_user_password="use_a_secret_here",
            cluster_type="single-node",
            db_name="bar",
            node_type="ds2.xlarge" 
        )
# {/fact}
