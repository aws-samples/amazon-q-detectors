# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-rds-encryption@v1.0 defects=1}
resource "aws_db_instance" "default" {
  allocated_storage    = 10
  engine               = "mysql"
  engine_version       = "5.7"
  instance_class       = "db.t3.micro"
  name                 = "mydb"
  username             = "foo"
  password             = "foobarbaz"
  parameter_group_name = "default.mysql5.7"
  # Noncompliant: All data stored in the RDS is not encrypted at rest.
  skip_final_snapshot  = true
  iam_database_authentication_enabled = true
  multi_az             = true
  auto_minor_version_upgrade = true
  monitoring_interval  = 5
  enabled_cloudwatch_logs_exports = ["general", "error", "slowquery"]
  performance_insights_kms_key_id = aws_kms_key.pike.arn
  deletion_protection = true
  performance_insights_enabled = true
  copy_tags_to_snapshot = true
}
# {/fact}