# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-non-default-port@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_rds import DatabaseCluster, DatabaseClusterEngine
from aws_cdk import aws_rds as rds

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)
    
    # Compliant: Default port is set.
    DatabaseCluster(self, 'rDbCluster', 
	    engine=DatabaseClusterEngine.aurora_mysql(version=rds.AuroraMysqlEngineVersion.VER_3_01_0),
	    port= 42,
	  )
    # {/fact}
