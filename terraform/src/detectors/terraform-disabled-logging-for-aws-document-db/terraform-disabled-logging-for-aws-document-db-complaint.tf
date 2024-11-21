# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-logging-for-aws-document-db@v1.0 defects=0}
resource "aws_docdb_cluster" "docdb" {
  cluster_identifier      = "my-docdb-cluster"
  # Compliant: Logging is enabled for the AWS DocumentDB instance.
  enabled_cloudwatch_logs_exports  = ["audit", "profiler"]
  storage_encrypted  = true
  kms_key_id                        = "ckv_kms"
}
# {/fact}