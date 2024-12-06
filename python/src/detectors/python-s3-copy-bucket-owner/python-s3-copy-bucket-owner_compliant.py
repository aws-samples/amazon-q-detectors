# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-s3-copy-bucket-owner@v1.0 defects=0}
import boto3

def compliant(src_key, bucketname, prefix, new_file_name):
    try:
        client = boto3.client('s3')
        copy_source = {'Bucket': bucketname, 'Key': src_key}
        # Compliant: Performing S3 operations using `ExpectedBucketOwner` and `ExpectedSourceBucketOwner` helps prevent accidental misuse in production.
        client.copy_object(CopySource=copy_source, Bucket=bucketname, Key=prefix + new_file_name, ExpectedBucketOwner="BUCKET_OWNER", ExpectedSourceBucketOwner="SOURCE_BUCKET_OWNER")
        client.delete_object(Bucket=bucketname, Key=src_key)
    except:
        raise NameError('ERROR RENAMING S3 src_key!!!')
# {/fact}
