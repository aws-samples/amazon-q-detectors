# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-mks-client-to-broker-tls@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_msk import CfnCluster

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Uses `TLS_PLAINTEXT`, which allows unencrypted communication and reduces security.
        CfnCluster(self, 'rMsk', 
            cluster_name='foo',
            kafka_version='2.8.0',
            number_of_broker_nodes=42,
            encryption_info=CfnCluster.EncryptionInfoProperty(
                encryption_at_rest=CfnCluster.EncryptionAtRestProperty(
                    data_volume_kms_key_id="dataVolumeKmsKeyId"
                ),
                encryption_in_transit=CfnCluster.EncryptionInTransitProperty(
                    client_broker='TLS_PLAINTEXT'
                ),
                logging_info=CfnCluster.LoggingInfoProperty(
                    broker_logs=CfnCluster.BrokerLogsProperty(
                        cloudwatch_logs=CfnCluster.CloudWatchLogsProperty(
                            enabled=True,
                            log_group="MyKafkaClusterLogs"
                        ),
                        firehose=CfnCluster.FirehoseProperty(
                            enabled=True,
                            delivery_stream="deliveryStream"
                        ),
                        s3=CfnCluster.S3Property(
                            enabled=True,
                            bucket="XXXXXXXXXXXXXXbucket",
                            prefix="kafka-logs/"
                        )
                    )
                )
            )
        )
# {/fact}
