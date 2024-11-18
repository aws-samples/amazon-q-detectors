# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-athena-database-encryption@v1.0 defects=0}
resource "aws_athena_database" "example" {
    name   = "athena"
    # Compliant: The Athena database is encrypted at rest.
    encryption_configuration {
    encryption_option = var.encryption_option
    kms_key           = var.kms_key_arn
 }
  bucket = ""
}
# {/fact}