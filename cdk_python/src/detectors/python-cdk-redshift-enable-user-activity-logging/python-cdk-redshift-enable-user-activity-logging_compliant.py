# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-redshift-enable-user-activity-logging@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_redshift import CfnCluster, CfnClusterParameterGroup

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        compliantParamGroup2 = CfnClusterParameterGroup(
          self,
          'rCfnParameterGroup',
            description='foo',
            parameter_group_family='redshift-1.0',
            parameters=[
              CfnClusterParameterGroup.ParameterProperty(
                parameter_name='enable_user_activity_logging',
                parameter_value='True'
              )
            ]
        )
        # Compliant: Activity logging is enabled by setting `enable_user_activity_logging` to `True`.
        CfnCluster(self, 'rCfnRedshiftCluster', 
            master_username='use_a_secret_here',
            master_user_password='use_a_secret_here',
            cluster_type='single-node',
            db_name='bar',
            node_type='ds2.xlarge',
            cluster_parameter_group_name=compliantParamGroup2
        )
# {/fact}
