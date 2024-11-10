# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-quicksight-ssl-connections@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_quicksight import CfnDataSource
from aws_cdk.aws_quicksight.CfnDataSource import SslPropertiesProperty 


class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)   
        # Compliant: `disable_ssl` is set to `False`.
        CfnDataSource(Stack, 'rDashboard', 
            ssl_properties= SslPropertiesProperty(
        disable_ssl=False),
        )

# {/fact}