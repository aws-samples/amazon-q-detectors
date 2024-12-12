# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-public-read-bucket-acl@v1.0 defects=1}
resource "aws_s3_bucket" "public_bucket" {
  bucket = "example-public-bucket"
  # Noncompliant: The AWS S3 bucket ACL grants READ permission to all users.
  acl = "public-read"
   lifecycle_rule {
     id     = "expire"
     status = "Enabled"
     prefix = "logs/"
     transition {
       days          = 30
       storage_class = "STANDARD_IA"
     }
     expiration {
       days = 90
     }
   }
}

resource "aws_sns_topic" "bucket_notifications" {
  name = "bucket-notifications"
  kms_master_key_id = "alias/aws/sns"
}

resource "aws_s3_bucket_notification" "bucket_notification" {
  bucket = aws_s3_bucket.public_bucket.id

  topic {
    topic_arn     = aws_sns_topic.bucket_notifications.arn
    events        = ["s3:ObjectCreated:*"]
    filter_prefix = "logs/"
  }
}

resource "aws_s3_bucket_logging" "example" {
   bucket = aws_s3_bucket.public_bucket.id
   target_bucket = aws_s3_bucket.public_bucket.id
   target_prefix = "log/"
}

resource "aws_s3_bucket_public_access_block" "access_good_1" {
  bucket = aws_s3_bucket.public_bucket.id
  block_public_acls   = true
  block_public_policy = true
  ignore_public_acls=true
  restrict_public_buckets = true
}

resource "aws_s3_bucket_server_side_encryption_configuration" "good_sse_1" {
    bucket = aws_s3_bucket.public_bucket.bucket
    rule {
      apply_server_side_encryption_by_default {
        kms_master_key_id = aws_kms_key.mykey.arn
        sse_algorithm     = "aws:kms"
      }
    }
  }

resource "aws_s3_bucket_versioning" "example" {
    bucket = aws_s3_bucket.public_bucket.id
    versioning_configuration {
      status = "Enabled"
    }
  }

resource "aws_s3_bucket_replication_configuration" "east_to_west" {
    depends_on = [aws_s3_bucket_versioning.east]
    role   = aws_iam_role.east_replication.arn
    bucket = aws_s3_bucket.public_bucket.id
    rule {
      status = "Enabled"
      destination {
        bucket        = aws_s3_bucket.public_bucket.arn
        storage_class = "STANDARD"
      }
    }
  }
# {/fact}
