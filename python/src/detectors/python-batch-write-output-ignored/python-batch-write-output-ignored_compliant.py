# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-batch-write-output-ignored@v1.0 defects=0}
import boto3

def compliant():
    firehose_client = boto3.client('firehose')
    # Compliant: Calling a batch operation with handling errors returned by that batch operation helps to prevent potential system instability.
    response = firehose_client.put_record_batch(DeliveryStreamName=delivery_stream_name, Records=batch_to_send)
    failed_records = [record for record in response.get('RequestResponses', []) if record.get('ErrorCode')]
    if failed_records:
        raise RuntimeError(f"Failed to send {len(failed_records)} records to Firehose")
# {/fact}
