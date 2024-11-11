#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-reencrypt@v1.0 defects=1}
import boto3
import base64

def kms_reencrypt_noncompliant():
    client = boto3.client('kms', region_name='us-east-1')
    plaintext = client.decrypt(
        CiphertextBlob=bytes(base64.b64decode("secret"))
    )
    # Noncompliant: Decrypt is immediately followed by encrypt.
    response = client.encrypt(
        KeyId='string',
        Plaintext=plaintext
    )
    return response
# {/fact}
