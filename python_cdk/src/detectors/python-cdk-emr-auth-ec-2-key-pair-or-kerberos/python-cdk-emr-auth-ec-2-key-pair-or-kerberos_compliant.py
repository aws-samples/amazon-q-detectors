# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-emr-auth-ec-2-key-pair-or-kerberos@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_emr import CfnCluster
from aws_cdk.aws_emr.CfnCluster import InstanceGroupConfigProperty,KerberosAttributesProperty
from aws_cdk import aws_emr as emr
	 
class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)   
        
    # Compliant: The CfnCluster instantiation sets the kerberos_attributes property with KerberosAttributesProperty, including kdc_admin_password and realm.
    CfnCluster(self, 'rEmrCluster', 
        instances= InstanceGroupConfigProperty(),
        job_flow_role= ' EMR_EC2_DefaultRole',
        name= 'foo',
        serviceRole= 'bar',
        kerberos_attributes=KerberosAttributesProperty(
        kdc_admin_password= 'baz',
        realm= 'qux',
        ),
    )
    # {/fact}
