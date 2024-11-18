# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-iam-authentication@v1.0 defects=1}
resource "aws_db_instance" "default" {
  allocated_storage           = 10
  engine                      = "mysql"
  engine_version              = "5.7"
  instance_class              = "db.t2.micro"
  name                        = "mydb"
  username                    = "foo"
  password                    = "foobarbaz"
  parameter_group_name        = "default.mysql5.7"
  performance_insights_enabled = true
  performance_insights_kms_key_id = "<KMS_KEY_ARN>"
  # Noncompliant: IAM authentication is disabled for the RDS database.
  deletion_protection  = true
  multi_az             = true
  enabled_cloudwatch_logs_exports = ["general", "error", "slowquery"]
  auto_minor_version_upgrade = true
  monitoring_interval  = 5
  storage_encrypted = true
  copy_tags_to_snapshot     = true
}
# {/fact}