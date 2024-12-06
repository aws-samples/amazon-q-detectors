# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-not-recommended-apis@v1.0 defects=0}
import boto3

def compliant():
    kinesis_client = boto3.client("kinesis")
    # Compliant: Using enhanced `Fan-Out` through `subscribe_to_shard` provides dedicated throughput per consumer.
    for record in kinesis_client.get_records(ShardIterator='shard-iterator'):
        print(record)
# {/fact}
