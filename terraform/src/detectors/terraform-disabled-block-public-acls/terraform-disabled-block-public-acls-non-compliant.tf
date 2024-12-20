# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-block-public-acls@v1.0 defects=1}
resource "aws_s3_bucket_public_access_block" "access_bucket" {
     bucket = aws_s3_bucket.bucket_good_1.id
     # Noncompliant: The block public access setting is disabled for AWS S3 Buckets.
     block_public_acls   = false
     block_public_policy = true
     ignore_public_acls=true
     restrict_public_buckets = true
   }
# {/fact}
