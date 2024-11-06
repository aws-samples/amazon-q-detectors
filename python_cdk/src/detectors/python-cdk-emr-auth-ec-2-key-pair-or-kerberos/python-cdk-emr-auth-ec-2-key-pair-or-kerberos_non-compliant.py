# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-emr-auth-ec-2-key-pair-or-kerberos@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_emr import CfnCluster
from aws_cdk.aws_emr.CfnCluster import InstanceGroupConfigProperty,KerberosAttributesProperty
from aws_cdk import aws_emr as emr
	 
class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)   
        
    # Noncompliant: `kerberos_attributes` is not set.
    CfnCluster(self, 'rEmrCluster',
        instances = InstanceGroupConfigProperty() ,
        job_flow_role= ' EMR_EC2_DefaultRole',
        name= 'foo',
        serviceRole= 'bar',
    )
   