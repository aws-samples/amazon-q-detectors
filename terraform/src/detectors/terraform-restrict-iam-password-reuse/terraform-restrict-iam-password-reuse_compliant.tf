# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-restrict-iam-password-reuse@v1.0 defects=0}
resource "aws_iam_account_password_policy" "pike" {
  allow_users_to_change_password = true
  hard_expiry                    = true
  max_password_age               = 90
  minimum_password_length        = 14
  # Compliant: IAM password policy prevent reuse of passwords
  password_reuse_prevention      = 24
  require_lowercase_characters   = true
  require_numbers                = true
  require_symbols                = true
  require_uppercase_characters   = true
}
# {/fact}