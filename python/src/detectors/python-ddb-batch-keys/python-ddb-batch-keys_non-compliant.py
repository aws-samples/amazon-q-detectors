# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-ddb-batch-keys@v1.0 defects=1}
import boto3 as bt3

def non_compliant(items):
    dynamodb_conn = bt3.client('dynamodb')
    batch_list = dynamodb_conn.new_batch_write_list()
    batch_list.add_batch(dynamodb_table, puts=items)
    # Noncompliant: Using `DynamoDB` batch operations introduces potential risks where individual request failures can compromise data integrity.
    response = dynamodb_conn.batch_write_item(batch_list)
    return response
# {/fact}
