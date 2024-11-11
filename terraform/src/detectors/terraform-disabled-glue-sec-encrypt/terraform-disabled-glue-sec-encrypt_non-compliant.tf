# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-glue-sec-encrypt@v1.0 defects=1}
resource "aws_glue_security_configuration" "sampletest" {
  name  = "sample"

  # Noncompliant: Glue Security Configuration Encryption is disabled.
  encryption_configuration {
    cloudwatch_encryption {
      cloudwatch_encryption_mode = "DISABLED"
    }

    job_bookmarks_encryption {
      job_bookmarks_encryption_mode = "DISABLED"
    }

    s3_encryption {
      kms_key_arn        = var.aws_kms_key
      s3_encryption_mode = "SSE-KMS"
    }
  }
}
# {/fact}