# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-rds-non-default-port@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_rds import AuroraMysqlEngineVersion, DatabaseCluster

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Noncompliant: The DatabaseCluster instantiation does not set a custom port value, using the default port instead.
    DatabaseCluster(self, 'rDbCluster', 
	    engine=rds.DatabaseClusterEngine.aurora_mysql(version=AuroraMysqlEngineVersion.VER_3_01_0),
	  )
    # {/fact}
