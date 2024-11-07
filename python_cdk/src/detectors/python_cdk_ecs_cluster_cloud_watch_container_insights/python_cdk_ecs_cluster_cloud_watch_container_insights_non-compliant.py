# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-ecs-cluster-cloud-watch-container-insights@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ecs import Cluster

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        # Noncompliant: `container_insights` is set to `False`.
        Cluster(Stack, 'rCluster', container_insights= False)
	    # {/fact}
