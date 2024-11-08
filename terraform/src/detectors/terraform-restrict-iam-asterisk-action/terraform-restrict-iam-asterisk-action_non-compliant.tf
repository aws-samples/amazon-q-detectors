# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-iam-asterisk-action@v1.0 defects=1}
data "aws_iam_policy_document" "policy" {
  version = "2012-10-17"

  # Noncompliant: IAM policy documents detect the use of asterisk as an action for statements.
  statement {
    actions = ["*"]
    effect  = "Allow"
    resources = [
      "*"
    ]
  }
}
# {/fact}