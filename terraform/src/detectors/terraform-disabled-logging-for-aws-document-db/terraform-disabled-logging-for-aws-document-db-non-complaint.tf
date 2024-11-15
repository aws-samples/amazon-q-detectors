# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-logging-for-aws-document-db@v1.0 defects=1}
resource "aws_docdb_cluster" "docdb" {
  cluster_identifier      = "my-docdb-cluster"
  # Noncompliant: Logging is disabled for the AWS DocumentDB instance.
  storage_encrypted  = true
  kms_key_id                        = "ckv_kms"
}
# {/fact}