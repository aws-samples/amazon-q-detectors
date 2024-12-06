# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-ddb-batch-keys@v1.0 defects=0}
import boto3 as bt3

def compliant(items):
    dynamodb_conn = bt3.client('dynamodb')
    batch_list = dynamodb_conn.new_batch_write_list()
    batch_list.add_batch(dynamodb_table, puts=items)
    response = dynamodb_conn.batch_write_item(batch_list)
    # Compliant: Using `UnprocessedItems` to check if all requests succeeded.
    while response.get('UnprocessedItems'):
        response = dynamodb_conn.batch_write_item(UnprocessedItems=response['UnprocessedItems'])
    
    return response
# {/fact}
