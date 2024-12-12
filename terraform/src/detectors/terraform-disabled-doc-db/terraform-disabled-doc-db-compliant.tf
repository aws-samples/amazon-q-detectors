# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-disabled-doc-db@v1.0 defects=0}
resource "aws_docdb_cluster_parameter_group" "example" {
  name        = "example"
  parameter {
    name  = "tls"
    # Compliant: TLS is enabled for Amazon DocumentDB.
    value = "enabled"
  }
  parameter {
    name  = "audit_logs"
    value = "enabled"
  }
  family = ""
}
# {/fact}
