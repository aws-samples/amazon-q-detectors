#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-missing-pagination@v1.0 defects=1}
import boto3

def s3_loop_noncompliant(s3bucket_name, s3prefix_name):

    s3_client = boto3.resource('s3', region_name='us-east-1').meta.client
    # Noncompliant: Loops through the contents without checking whether more requests are needed.
    list_object_response = s3_client.list_objects_v2(Bucket=s3bucket_name,
                                                     Prefix=s3prefix_name)
    try:
        if 'Contents' in list_object_response:
            s3_deployment_folders = list_object_response['Contents']
            return s3_deployment_folders

    except ListException:
        print("List objects in bucket {} with prefix {} "
              "failed with response {}".format(s3bucket_name,
                                               s3prefix_name,
                                               list_object_response))
# {/fact}
