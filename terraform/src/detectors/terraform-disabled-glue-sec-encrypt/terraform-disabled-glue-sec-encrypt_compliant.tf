# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-glue-sec-encrypt@v1.0 defects=0}
resource "aws_glue_security_configuration" "sampletest" {
  name  = "sample"

  # Compliant: Glue Security Configuration Encryption is enabled.
  encryption_configuration {
    cloudwatch_encryption {
      cloudwatch_encryption_mode = "SSE-KMS"
      kms_key_arn = "arn:aws:kms:eu-west-2:680235478471:key/34cdce9a-2322-427c-91bb-b572f435c032"
    }

    job_bookmarks_encryption {
      job_bookmarks_encryption_mode = "CSE-KMS"
      kms_key_arn = "arn:aws:kms:eu-west-2:680235478471:key/34cdce9a-2322-427c-91bb-b572f435c032"
    }

    s3_encryption {
      kms_key_arn = "arn:aws:kms:eu-west-2:680235478471:key/34cdce9a-2322-427c-91bb-b572f435c032"
      s3_encryption_mode = "SSE-KMS"
    }
  }
}
# {/fact}