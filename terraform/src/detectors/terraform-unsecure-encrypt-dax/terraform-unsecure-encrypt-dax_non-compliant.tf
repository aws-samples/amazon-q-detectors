# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-unsecure-encrypt-dax@v1.0 defects=1}
resource "aws_dax_cluster" "cloudrail-test" {
  cluster_name       = "non-encrypt"
  iam_role_arn       = aws_iam_role.dax.arn
  node_type          = "dax.r4.large"
  replication_factor = 1
  cluster_endpoint_encryption_type = "TLS"
  # Noncompliant: DAX is not encrypted at rest.
  server_side_encryption {
    enabled = False
  }
}
# {/fact}
