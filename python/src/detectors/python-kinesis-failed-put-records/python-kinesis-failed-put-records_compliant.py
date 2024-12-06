# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-kinesis-failed-put-records@v1.0 defects=0}
import boto3

def compliant(self, agg_record: aggregator.AggRecord) -> None:
    self.kinesis_client = boto3.client('kinesis')
    pk, ehk, data = agg_record.get_contents()
    response = self.kinesis_client.put_records(StreamName=stream_name, Records=[{'Data': data, 'PartitionKey': pk}])
    # Compliant: Using Batch request with checked failures helps to prevent silent data inconsistencies and potential system-wide reliability issues.
    failed_records = response['FailedRecordCount']
    if failed_records > 0:
        pass
# {/fact}
