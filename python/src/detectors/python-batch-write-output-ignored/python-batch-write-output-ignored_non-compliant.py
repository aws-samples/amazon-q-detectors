# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-batch-write-output-ignored@v1.0 defects=1}
import boto3

def non_compliant():
    firehose_client = boto3.client('firehose')
    # Noncompliant: Calling a batch operation without handling any errors returned by that batch operation can lead to potential system instability.
    firehose_client.put_record_batch(DeliveryStreamName=delivery_stream_name, Records=batch_to_send)
# {/fact}
