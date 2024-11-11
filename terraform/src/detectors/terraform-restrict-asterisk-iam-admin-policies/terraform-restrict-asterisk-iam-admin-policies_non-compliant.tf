# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-asterisk-iam-admin-policies@v1.0 defects=1}
data "aws_iam_policy_document" "policy" {
  version = "2012-10-17"

  # Noncompliant: IAM policy grants full administrative privileges.
  statement {
    actions = ["*"]
    effect  = "Allow"
    resources = [
      "*"
    ]
  }
}
# {/fact}