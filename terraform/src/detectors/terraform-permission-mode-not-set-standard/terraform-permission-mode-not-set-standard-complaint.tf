# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

# {fact rule=terraform-permission-mode-not-set-standard@v1.0 defects=0}
resource "aws_qldb_ledger" "ledger" {
  name                = "ledger"
  # Compliant: The QLDB ledger permissions mode is STANDARD.
  permissions_mode    = "STANDARD"

  tags = {
    Environment = "Production"
    Purpose     = "Secure-Audit-Logs"
  }
}
# {/fact}