# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-msk-broker-logging@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_msk import CfnCluster

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Configures logging to S3 and CloudWatch, ensuring proper monitoring and auditing.
        CfnCluster(self, 'rMsk',
            cluster_name= 'foo',
            kafka_version= '2.8.0',
            broker_node_group_info=CfnCluster.BrokerNodeGroupInfoProperty (
                client_subnets= ['bar'],
                instance_type= 'kafka.m5.large',
            ),
            number_of_broker_nodes= 42,
            logging_info= CfnCluster.LoggingInfoProperty( 
                broker_logs= CfnCluster.BrokerLogsProperty(
                    cloud_watch_logs=CfnCluster.CloudWatchLogsProperty(
                      enabled=True,log_group="logGroup"
                    ),
                    s3=CfnCluster.S3Property(
                      enabled=True,bucket="bucket"
                    )
                )
            )
        )
# {/fact}
