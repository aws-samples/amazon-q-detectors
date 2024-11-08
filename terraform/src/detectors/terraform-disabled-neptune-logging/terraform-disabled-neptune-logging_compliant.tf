# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-neptune-logging@v1.0 defects=0}
resource "aws_neptune_cluster" "test" {
  cluster_identifier                  = "neptune-cluster-demo"
  engine                              = "neptune"
  backup_retention_period             = 5
  preferred_backup_window             = "07:00-09:00"
  skip_final_snapshot                 = true
  iam_database_authentication_enabled = true
  apply_immediately                   = true
  # Compliant: Neptune logging is enabled.
  enable_cloudwatch_logs_exports      = ["audit"]
  storage_encrypted                   = true
  deletion_protection                 = true
  kms_key_arn                         = aws_kms_key.pike.arn
}
# {/fact}