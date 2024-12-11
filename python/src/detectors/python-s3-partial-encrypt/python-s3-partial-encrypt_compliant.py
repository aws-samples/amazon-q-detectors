# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-s3-partial-encrypt@v1.0 defects=0}
import boto3
client = boto3.client('s3')

def compliant():
    try:
        client.put_object(
            Body='filetoupload',
            Bucket='XXXXXXXXXXXXX',
            Key='objectkey',
            SSEKMSKeyId="keyId"
        )
    finally:
        # Compliant: Using `server-side encryption` on all paths minimize potential security risks.
        client.put_object(
            Body='filetoupload',
            Bucket='XXXXXXXXXXXXX',
            Key='objectkey',
            SSEKMSKeyId="keyId"
        )
# {/fact}
