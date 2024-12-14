# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=python-cdk-public-s3-bucket@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import aws_s3 as s3

class CdkStarter(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        
        # Noncompliant: Bucket has public access which is security sensitive.
        publicBucket=s3.Bucket(self, 'bucket')
        publicBucket.grant_public_access()
# {/fact}
 