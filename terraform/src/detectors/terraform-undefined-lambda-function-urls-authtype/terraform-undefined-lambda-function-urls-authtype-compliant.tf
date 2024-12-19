# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-undefined-lambda-function-urls-authtype@v1.0 defects=0}
resource "aws_cloudwatch_log_group" "cloudwatch" {
  # Compliant: The AWS CloudWatch Log groups are encrypted using a KMS Customer Master Key (CMK) instead of the default encryption key.
  kms_key_id        = "someKey"
  retention_in_days = 365
}
# {/fact}
