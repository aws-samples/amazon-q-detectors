# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-clb-connection-draining@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import  Stack
from aws_cdk.aws_elasticloadbalancing import CfnLoadBalancer
from aws_cdk import aws_elasticloadbalancing as elb

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Enables connection draining for graceful termination.
        CfnLoadBalancer(Stack, 'rCfnElb', listeners=[elb.CfnLoadBalancer.ListenersProperty(
            instance_port="instancePort",
            load_balancer_port="loadBalancerPort",
            protocol="protocol",
            instance_protocol="instanceProtocol",
            policy_names=["policyNames"],
            ssl_certificate_id="sslCertificateId"
        )], connection_draining_policy=CfnLoadBalancer.ConnectionDrainingPolicyProperty(enabled=True))
# {/fact}
