#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0

# {fact rule=python-ami-describe-image-request@v1.0 defects=1}
import boto3

def image_filter_non_compliant():
    ec2 = boto3.resource('ec2', region_name='us-east-1')
    image_name = 'The name of the AMI (provided during image creation)'
    # Noncompliant: Requests Amazon Machine Images (AMIs) with only name filter ignoring owner or AMI identifiers.
    filters = [{'Name': 'name', 'Values': [image_name]}]
    images = ec2.images.filter(Filters=filters)
# {/fact}
