# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-redshift-require-tls-ssl@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_redshift import CfnCluster, CfnClusterParameterGroup  

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        param_group=CfnClusterParameterGroup(
            self, "rRedshiftParamGroup",
            description="Cluster parameter group",
            parameter_group_family="redshift-1.0",  
            parameters=[CfnClusterParameterGroup.ParameterProperty(
                parameter_name= "require_ssl", parameter_value= "True")
            ]
        )
        # Compliant: Parameter group configured with `require_ssl: True` enforces SSL/TLS encrypted connections.
        CfnCluster(self, "rRedshiftCluster",
            master_username="secret",
            master_user_password="secret", 
            cluster_type="single-node",
            db_name="testdb",
            node_type="ds2.xlarge",
            cluster_parameter_group_name=param_group.ref
        )
# {/fact}
