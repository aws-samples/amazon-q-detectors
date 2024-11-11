# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-aurora-encryption@v1.0 defects=1}
resource "aws_rds_cluster" "default" {
  cluster_identifier      = "aurora-cluster-demo"
  engine                  = "aurora-mysql"
  engine_version          = "5.7.mysql_aurora.2.03.2"
  availability_zones      = ["us-west-2a", "us-west-2b", "us-west-2c"]
  database_name           = "mydb"
  backtrack_window        = 7
  kms_key_id              = aws_kms_key.pike.arn
  enabled_cloudwatch_logs_exports = ["audit"]
  master_username         = "foo"
  master_password         = "bar"
  preferred_backup_window = "07:00-09:00"
  # Noncompliant: All data stored in Aurora is not encrypted at rest.
  storage_encrypted       = false
  copy_tags_to_snapshot = true
  iam_database_authentication_enabled = true
  deletion_protection = true
}
resource "aws_backup_selection" "backup_good" {
  iam_role_arn = "arn:partition:service:region:account-id:resource-id"
  name         = "tf_example_backup_selection"
  plan_id      = aws_backup_plan.example.id

  resources = [
    aws_rds_cluster.default.arn
  ]
}
# {/fact}