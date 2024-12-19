# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-public-s3-bucket@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk.aws_s3 import Bucket

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        
        # Compliant: Bucket has public access disabled.
        nonPublicBucketDirect=Bucket(self, 'bucket')
# {/fact}
