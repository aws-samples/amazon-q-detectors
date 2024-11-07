# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-emrs-3-access-logging@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_emr import CfnCluster
from aws_cdk import aws_emr as emr

class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)
      # Compliant: The CfnCluster instantiation sets the `log_uri` property.
      CfnCluster(self, 'rEmrCluster', job_flow_role = ' EMR_EC2_DefaultRole', name = 'foo', service_role = 'bar', log_uri= 'baz')
      
# {/fact}