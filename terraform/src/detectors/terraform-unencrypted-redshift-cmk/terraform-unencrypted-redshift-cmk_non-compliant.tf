# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unencrypted-redshift-cmk@v1.0 defects=1}
resource "aws_redshift_cluster" "test" {
  # Noncompliant: All data stored in the Redshift cluster is not encrypted at rest.
  cluster_identifier = "redshift-defaults-only"
  database_name = "mydb"
  node_type = "dc2.large"
  master_password = "Test1234"
  master_username = "test"
  skip_final_snapshot = true
  kms_key_id = aws_kms_key.test.arn
  publicly_accessible= "false"
  cluster_subnet_group_name="subnet-ebd9cead"
  logging {
    enable = "true"
  }
  enhanced_vpc_routing = true
}
# {/fact}