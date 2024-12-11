#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-sync-metric-publish@v1.0 defects=1}
import boto3
client = boto3.client('cloudwatch')

# Noncompliant: Lambda handler that publishes metrics synchronously, which can block execution.
def non_compliant_handler(event, context):

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
