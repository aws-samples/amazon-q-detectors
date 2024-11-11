# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-associate-glue-security@v1.0 defects=0}
resource "aws_glue_crawler" "cloudrail_table_crawler" {
  database_name = aws_glue_catalog_database.cloudrail_table_database.name
  name          = "cloudrail_table_crawler"
  role          = aws_iam_role.cloudrail_glue_iam.arn

  s3_target {
    path = "s3://${aws_s3_bucket.cloudrail.bucket}"
  }
  # Compliant: Glue component has a security configuration associated.
  security_configuration = aws_glue_security_configuration.example.name
}
# {/fact}