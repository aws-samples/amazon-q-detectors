# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-kms-key-length-128@v1.0 defects=1}
from aiohttp import ClientError
import boto3
from pip._internal.utils import logging


def non_compliant():
    kms_client = boto3.client('kms')
    try:
        # Noncompliant: Using 128-bit keys may expose your system to potential insecure cryptography.
        response = kms_client.generate_data_key(
            KeyId='string',
            NumberOfBytes=16
        )
        return response
    except ClientError as e:
        logging.error(e)
        return None, None
# {/fact}
