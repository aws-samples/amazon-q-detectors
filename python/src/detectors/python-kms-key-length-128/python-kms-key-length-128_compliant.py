# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-kms-key-length-128@v1.0 defects=0}
from aiohttp import ClientError
import boto3
from pip._internal.utils import logging

def compliant():
    kms_client = boto3.client('kms')
    try:
        # Compliant: Using 256-bit keys helps to prevent potential insecure cryptography.
        response = kms_client.generate_data_key(
            KeyId='string',
            KeySpec='AES_256'
        )
        return response
    except ClientError as e:
        logging.error(e)
        return None, None
# {/fact}
