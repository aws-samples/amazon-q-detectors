#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sync-metric-publish@v1.0 defects=0}
import boto3
client = boto3.client('cloudwatch')

# Compliant: Regular function that publishes metrics without Lambda context parameters.
def compliant_handler():

    client.put_metric_data(
        Namespace="AWSFirmwareJenkinsMonitor",
        MetricData=[
            {
                'MetricName': 'Number of Releaseworks Tutorials',
                'Unit': 'Count',
                'Value': "Some_value"
            }
        ]
    )
# {/fact}
