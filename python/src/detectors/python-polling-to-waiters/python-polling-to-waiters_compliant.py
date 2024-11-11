#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-polling-to-waiters@v1.0 defects=0}
import boto3

def polling_vs_waiters_compliant(response):
    ec2_client = boto3.client('ec2', region_name='us-east-1')
    ec2_instance_id = response['Instances'][0]['InstanceId']
    waiter_config = {'Delay': 15, 'MaxAttempts': 40}
    # Compliant: Waiters feature is used for polling.
    try:
        ec2_client.get_waiter('instance_running').wait(InstanceIds=[ec2_instance_id], WaiterConfig=waiter_config)
        ec2_client.get_waiter('instance_status_ok').wait(InstanceIds=[ec2_instance_id], WaiterConfig=waiter_config)
        print("EC2 instance is up and running with ok status")
        return True
    except WaiterError as e:
        print(f"Error waiting for EC2 instance: {e}")
        tear_down()
        return False
# {/fact}
