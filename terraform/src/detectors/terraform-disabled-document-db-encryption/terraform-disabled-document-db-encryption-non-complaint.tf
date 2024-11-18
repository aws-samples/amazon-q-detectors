# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-document-db-encryption@v1.0 defects=1}
resource "aws_docdb_cluster" "example" {
  cluster_identifier      = "docdb-cluster-demo"
  engine                  = "docdb"
  availability_zones      = ["us-west-2a", "us-west-2b", "us-west-2c"]
  database_name           = "mydb"
  master_username         = "root"
  backup_retention_period = 5
  preferred_backup_window = "07:00-09:00"
  # Noncompliant: The DocumentDB instance is not encrypted at rest.
  storage_encrypted       = false

  parameter{
    name  = "audit_logs"
    value = "enabled"
  }
  enabled_cloudwatch_logs_exports  = ["audit", "profiler"]
  kms_key_id              = "arn:aws:kms:region:account-id:key/key-id"
}
# {/fact}