# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-quicksight-ssl-connections@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_quicksight import CfnDataSource
from aws_cdk.aws_quicksight.CfnDataSource import SslPropertiesProperty
from aws_cdk import aws_quicksight as quicksight 


class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)   
        # Noncompliant: `disable_ssl` is set to `True`.
        CfnDataSource(Stack, 'rDashboard', 
            ssl_properties= SslPropertiesProperty(
        disable_ssl=True),
        )
        # {/fact} 
       