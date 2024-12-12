# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-secrets-manager-using-cmk@v1.0 defects=1}
resource "aws_secretsmanager_secret" "example" {
  name = "my-non-compliant-secret"
  # Noncompliant: The AWS Secrets Manager secret is not encrypted using a Customer Managed Key (CMK).
}

resource "aws_secretsmanager_secret_rotation" "example" {
    secret_id           = aws_secretsmanager_secret.example.id
    rotation_lambda_arn = aws_lambda_function.example.arn
    rotation_rules {
      automatically_after_days = 30
    }
  }
# {/fact}
