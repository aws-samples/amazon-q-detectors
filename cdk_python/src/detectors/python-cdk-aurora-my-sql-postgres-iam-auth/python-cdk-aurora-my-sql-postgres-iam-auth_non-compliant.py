# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-aurora-my-postgres-iam-auth@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_rds import (
    AuroraMysqlEngineVersion,
    DatabaseCluster,
    DatabaseClusterEngine
)

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

	    # Noncompliant: Disables IAM authentication, relying on less secure authentication methods.
        DatabaseCluster(self, 'rDbCluster',
	          engine= DatabaseClusterEngine.aurora_mysql(version=AuroraMysqlEngineVersion.VER_3_01_0),
	          iam_authentication=False
	      )
# {/fact}
