# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-iam-asterisk-action@v1.0 defects=0}
data "aws_iam_policy_document" "policy" {
  version = "2012-10-17"

  # Compliant: This IAM policy restricts administrative privileges.
  statement {
    actions = ["S3:*"]
    effect  = "Allow"
    resources = [
      "*"
    ]
  }
}
# {/fact}