# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-s3-principal-action@v1.0 defects=0}
resource "aws_s3_bucket_policy" "bucket_2_policy" {
  bucket = aws_s3_bucket.public-bucket.id
  # Compliant: S3 bucket is not allowing actions with any Principal.
  policy = <<POLICY
  {
    "Version":"2012-10-17",
    "Statement":[
      {
        "Sid":"PublicRead",
        "Effect":"Allow",
        "Principal": "aws-arn",
        "Action":["s3:GetObject","s3:GetObjectVersion"],
        "Resource":["arn:aws:s3:::bucket-with-public-policy-2/*"]
      }
    ]
  }
  POLICY
}
# {/fact}
