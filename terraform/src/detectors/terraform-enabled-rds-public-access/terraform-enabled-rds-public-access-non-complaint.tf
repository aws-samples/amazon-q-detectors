# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-enabled-rds-public-access@v1.0 defects=1}
resource "aws_db_instance" "default" {
  # Noncompliant: The AWS RDS database instance is publicly accessible.
  publicly_accessible   = true
  instance_class         = ""
  performance_insights_kms_key_id = "<KMS_KEY_ARN>"
  deletion_protection  = true
  performance_insights_enabled = true
  multi_az             = true
  enabled_cloudwatch_logs_exports = ["general", "error", "slowquery"]
  auto_minor_version_upgrade = true
  monitoring_interval  = 5
  storage_encrypted    = true
  copy_tags_to_snapshot     = true
}
# {/fact}