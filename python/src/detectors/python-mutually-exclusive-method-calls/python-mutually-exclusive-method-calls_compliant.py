# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-mutually-exclusive-method-calls@v1.0 defects=0}
import boto3

def compliant():
    client = boto3.client('cloudformation', region_name='eu-west-1')
    # Compliant: Setting two parameters seperately helps to prevent unexpected behavior or system errors.
    if stack_url:
        client.set_stack_policy(StackPolicyURL=stack_url)
    elif stack_policy_body:
        client.set_stack_policy(StackPolicyBody=stack_policy_body)
# {/fact}
