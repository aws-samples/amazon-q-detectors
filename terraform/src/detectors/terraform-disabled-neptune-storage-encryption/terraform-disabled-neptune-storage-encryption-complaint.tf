# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-neptune-storage-encryption@v1.0 defects=0}
resource "aws_neptune_cluster" "example" {
  cluster_identifier      = "example-neptune-cluster"
  engine                  = "neptune"
  engine_version          = "1.0.5.0"
  availability_zones      = ["us-west-2a", "us-west-2b", "us-west-2c"]
  # Compliant: The Neptune storage encrypted securely.
  storage_encrypted       = true
  backup_retention_period = 5
  preferred_backup_window = "07:00-09:00"
  enable_cloudwatch_logs_exports      = ["audit"]
  kms_key_arn = "arn:aws:kms:us-west-2:123456789012:key/abcd1234a1234deaa1234fgha12345678"
  deletion_protection     = true
}
# {/fact}