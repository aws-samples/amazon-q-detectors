# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-mutually-exclusive-method-calls@v1.0 defects=1}
import boto3

def non_compliant():
    client = boto3.client('cloudformation', region_name='eu-west-1')
    # Noncompliant: Setting two parameters that cannot be used together creates configuration conflicts that may lead to unexpected behavior or system errors.
    client.set_stack_policy(StackPolicyURL=stack_url, StackPolicyBody=stack_policy_body)
# {/fact}
