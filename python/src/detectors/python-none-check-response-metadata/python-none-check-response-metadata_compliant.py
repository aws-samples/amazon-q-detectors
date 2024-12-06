# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-none-check-response-metadata@v1.0 defects=0}
import boto3

def compliant():
    ddb_client = boto3.client('dynamodb')
    response = ddb_client.update_item()
    # Compliant: `None` check on the response object before accessing the response metadata is added.
    if response is not None:
        return response.get("ResponseMetadata", {})
    else:
        raise TypeError("Response metadata could not be retrieved due to NoneType response.")
# {/fact}
