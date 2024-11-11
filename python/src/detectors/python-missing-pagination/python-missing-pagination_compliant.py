#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-missing-pagination@v1.0 defects=0}
import boto3

def s3_recursion_compliant(self, s3bucket_name, s3prefix_name, token=None):

    s3_client = boto3.client('s3', region_name='us-east-1')
    list_object_response = s3_client.list_objects_v2(
        Bucket=s3bucket_name,
        Prefix=s3prefix_name,
        ContinuationToken=token
    ) if token else s3_client.list_objects_v2(Bucket=s3bucket_name,
                                              Prefix=s3prefix_name)

    s3_deployment_folders = list_object_response['Contents']
    # Compliant: Keeps requesting until no more requests are needed.
    if not list_object_response['IsTruncated']:
        return s3_deployment_folders

    next_response = self.s3_recursion_compliant(s3bucket_name, s3prefix_name,
                                                list_object_response
                                                ['NextContinuationToken'])
    s3_deployment_folders += next_response

    return s3_deployment_folders
# {/fact}
