# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-kinesis-failed-put-records@v1.0 defects=1}
import boto3

def non_compliant(self, agg_record: aggregator.AggRecord) -> None:
    self.kinesis_client = boto3.client('kinesis')
    pk, ehk, data = agg_record.get_contents()
    # Noncompliant: Using Batch request with unchecked failures leads to silent data inconsistencies and potential system-wide reliability issues.
    self.kinesis_client.put_records(StreamName=stream_name, Data=data, PartitionKey=pk)
# {/fact}
