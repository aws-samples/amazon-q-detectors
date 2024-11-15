# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-permission-mode-not-set-standard@v1.0 defects=1}
resource "aws_qldb_ledger" "ledger" {
  name                = "ledger"
  # Noncompliant: The QLDB ledger permissions mode is not in STANDARD.
  permissions_mode    = "ALLOW_ALL"

  tags = {
    Environment = "Production"
    Purpose     = "Secure-Audit-Logs"
  }
}
# {/fact}