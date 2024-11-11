#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-ami-describe-image-request@v1.0 defects=0}
import boto3

def image_filter_compliant():
    ec2 = boto3.resource('ec2', region_name='us-east-1')
    image_name = 'The name of the AMI (provided during image creation)'
    owner_id = 'The AWS account ID of the owner'
    # Compliant: Requests Amazon Machine Images (AMIs) with both name and owner-id filters.
    filters = [
        {'Name': 'name', 'Values': [image_name]},
        {'Name': 'owner-id', 'Values': [owner_id]}
    ]
    images = ec2.images.filter(Filters=filters)
# {/fact}
