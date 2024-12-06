# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-none-check-response-metadata@v1.0 defects=1}
import boto3

def non_compliant():
    ddb_client = boto3.client('dynamodb')
    response = ddb_client.update_item()
    # Noncompliant: Accessing the `ResponseMetadata` without performing a `None` check on the response object might cause a `NoneType TypeError`.
    return response.get("ResponseMetadata", {})
# {/fact}
