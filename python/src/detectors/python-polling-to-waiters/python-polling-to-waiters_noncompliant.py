#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-polling-to-waiters@v1.0 defects=1}
import time
import boto3

def polling_vs_waiters_noncompliant(response):
    ec2_client = boto3.client('ec2', region_name='us-east-1')
    ec2_instance_id = response['Instances'][0]['InstanceId']

    attempts = 0
    MAX_ATTEMPTS = 10
    while True:
        print("Waiting for EC2 instance to be up")
        # Noncompliant: Uses custom polling instead of waiters feature.
        rsp = ec2_client.describe_instance_status(
            InstanceIds=[
                str(ec2_instance_id)
            ],
            IncludeAllInstances=True
        )

        instance_status = rsp['Statuses'][0]['InstanceStatus']['Status']
        system_status = rsp['Statuses'][0]['SystemStatus']['Status']

        if str(instance_status) == 'ok' and str(system_status) == 'ok':
            break
        if str(instance_status) == 'impaired' or \
                str(instance_status) == 'insufficient-data' or \
                str(system_status) == 'failed' or \
                str(system_status) == 'insufficient-data':
            print('Instance status is ' + str(instance_status))
            print('System status is ' + str(system_status))
            tear_down()
            exit(1)

        attempts = attempts + 1
        if attempts >= MAX_ATTEMPTS:
            print("MAX wait time for EC2 instance to be up reached.")
            print("Tearing down")
            tear_down()
            exit(1)

        time.sleep(10)
# {/fact}
