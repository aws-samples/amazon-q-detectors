# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-msk-broker-to-broker-tls@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_msk import CfnCluster
from aws_cdk.aws_msk.CfnCluster import BrokerNodeGroupInfoProperty,EncryptionInTransitProperty

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        (scope, id)    
       
       # Noncompliant: EncryptionInTransitProperty's `in_cluster` is set to `False`.
        CfnCluster(Stack, 'rMsk', 
            cluster_ame= 'foo',
            kafka_version= '2.8.0',
            broker_node_group_info= BrokerNodeGroupInfoProperty(
            client_subnets= ['bar'],
            instance_type= 'kafka.m5.large',
            ),
            number_of_broker_nodes= 42,
            encryption_info= EncryptionInfoProperty(  encryption_in_transit=EncryptionInTransitProperty( in_cluster= False ) ),
        )
        #{/fact}
