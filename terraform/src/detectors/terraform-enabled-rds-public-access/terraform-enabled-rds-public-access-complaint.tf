# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-enabled-rds-public-access@v1.0 defects=0}
resource "aws_db_instance" "default" {
  # Compliant: The AWS RDS database instance is not publicly accessible.
  publicly_accessible   = false
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