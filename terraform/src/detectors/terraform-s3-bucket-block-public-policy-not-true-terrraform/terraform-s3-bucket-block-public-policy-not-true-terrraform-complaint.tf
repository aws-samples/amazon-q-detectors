# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-s3-bucket-block-public-policy-not-true-terrraform@v1.0 defects=0}
resource "aws_s3_bucket_public_access_block" "artifacts" {


  block_public_acls   = true
  # Compliant: S3 bucket is configured to BlockPublicPolicy.
  block_public_policy = true
  restrict_public_buckets = true
  ignore_public_acls=true
  bucket = "bucket"
}
# {/fact}