# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-undefined-lambda-function-urls-authtype@v1.0 defects=1}
resource "aws_cloudwatch_log_group" "cloudwatch" {
  # Noncompliant: The AWS CloudWatch Log groups are encrypted using the default encryption key instead of a KMS Customer Master Key (CMK).
  retention_in_days = 365
}
# {/fact}
