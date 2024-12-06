# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-s3-partial-encrypt@v1.0 defects=1}
import boto3
client = boto3.client('s3')

def non_compliant():
    try:
        client.put_object(
            Body='filetoupload',
            Bucket='examplebucket',
            Key='objectkey',
            SSEKMSKeyId="keyId"
        )
    finally:
        # Noncompliant: Using unencrypted data in a `server-side encrypted` S3 bucket may lead to potential security risks.
        client.put_object(
            Body='filetoupload',
            Bucket='examplebucket',
            Key='objectkey'
        )
# {/fact}
