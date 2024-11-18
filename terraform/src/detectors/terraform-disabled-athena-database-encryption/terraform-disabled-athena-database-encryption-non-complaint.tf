# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-athena-database-encryption@v1.0 defects=1}
resource "aws_athena_database" "example" {
  name = "athena"
  # Noncompliant: The Athena database is not encrypted at rest.
  bucket = ""
}
# {/fact}