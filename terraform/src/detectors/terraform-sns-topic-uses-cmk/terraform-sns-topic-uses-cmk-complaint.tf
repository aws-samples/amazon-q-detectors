# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-sns-topic-uses-cmk@v1.0 defects=0}
resource "aws_sns_topic" "topic" {
  name = "topic"

  # Compliant: The AWS SNS topic has SSE (Server-Side Encryption) enabled.
  kms_master_key_id = aws_kms_key.custom_sns_key.arn
}
# {/fact}