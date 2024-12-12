# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-redshift-cluster-audit-logging@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import SecretValue
from aws_cdk.aws_redshift import CfnCluster, LoggingPropertiesProperty

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables logging by specifying `logging_properties`, aiding in auditing and monitoring.
        CfnCluster(self, 'rRedshiftCluster',
            master_username=SecretValue.secrets_manager('redshift/master-username').to_string(), 
            master_user_password=SecretValue.secrets_manager('redshift/master-password').to_string(),
            cluster_type='single-node',
            db_name='bar',
            node_type='ds2.xlarge',
            logging_properties=LoggingPropertiesProperty(
                bucket_name='XXX',
                enable_logging=True,
                s3_key_prefix='redshift-logs/'
            ),
            encrypted=True
        )
# {/fact}
