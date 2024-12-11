# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-not-recommended-apis@v1.0 defects=1}
import boto3

def non_compliant():
    kinesis_client = boto3.client("kinesis")
    # Noncompliant: Consuming Kinesis records can lead to throughput limitations and contention with other consumers.
    for record in kinesis_client.get_records():
        print(record)
# {/fact}
