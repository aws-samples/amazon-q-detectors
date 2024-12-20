# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-s3-bucket-restrict-public-bucket@v1.0 defects=1}
resource "aws_s3_bucket_public_access_block" "example" {
  bucket = aws_s3_bucket.example.id

  block_public_acls       = true
  block_public_policy     = true
  ignore_public_acls      = true
  # Noncompliant: The AWS S3 bucket does not have the RestrictPublicBucket setting set to True.
  restrict_public_buckets = false
}
# {/fact}
