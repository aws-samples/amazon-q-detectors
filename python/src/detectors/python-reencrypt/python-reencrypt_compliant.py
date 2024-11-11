#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-reencrypt@v1.0 defects=0}
import boto3
import base64

def kms_reencrypt_compliant():
    client = boto3.client('kms', region_name='us-east-1')
    # Compliant: Server-side re-encryption.
    response = client.re_encrypt(
        CiphertextBlob=bytes(base64.b64decode("secret")),
        DestinationKeyId="string",
    )
    return response
# {/fact}
